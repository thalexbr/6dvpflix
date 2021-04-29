SHELL := /bin/bash

VERSION   := $(shell assets/scripts/semver.sh)
MAKE_ARGS := VERSION=${VERSION}

# help
default:
	cat ./Makefile

# clean will compile your code and also package it. For example, 
# if your pom says the project is a jar, it will create a jar for
# you when you package it and put it somewhere in the target 
# directory (by default). 
clean:
	find . -name "pom.xml" -exec mvn versions:set -DnewVersion=${VERSION} -f '{}' \;
	find . -name "pom.xml" -exec mvn clean package -f '{}' \;

# Create a docker image for services listed above
images:
	@echo "Generating docker image for eurekaserver"
	docker build -f eurekaserver/Dockerfile -t eurekaserver:${VERSION} --build-arg VERSION=${VERSION} --build-arg JAR_FILE=eurekaserver/target/*.jar .
	@echo "Generating docker image for movieservice"
	docker build -f movieservice/Dockerfile -t movieservice:${VERSION} --build-arg VERSION=${VERSION} --build-arg JAR_FILE=movieservice/target/*.jar .
	@echo "Generating docker image for userservice"
	docker build -f userservice/Dockerfile -t userservice:${VERSION} --build-arg VERSION=${VERSION} --build-arg JAR_FILE=userservice/target/*.jar .

run:
	# TODO: locate default port and set  
	# docker run -p 8080:8080  -p 8443:8443 spring-boot-java-example:latest

up: clean images run
SHELL := /bin/bash

VERSION   := $(shell assets/scripts/semver.sh)
MAKE_ARGS := VERSION=${VERSION}

DOCKER_RUN_FLAGS += --rm
DOCKER_RUN_FLAGS += -v ${PWD}:/app/src
DOCKER_RUN_FLAGS += -w /app/src
BUILD_IMAGE 	 ?= jailsonsilva/build-tools-fiap:v0.0.1
DOCKER_FLAGS     += ${DOCKER_RUN_FLAGS}
DOCKER_RUN_CMD   = docker run ${DOCKER_FLAGS} ${BUILD_IMAGE}

ifndef NOCOLOR
	RED    := $(shell tput -Txterm setaf 1)
	GREEN  := $(shell tput -Txterm setaf 2)
	YELLOW := $(shell tput -Txterm setaf 3)
	RESET  := $(shell tput -Txterm sgr0)
endif

# help
default:
	cat ./Makefile

## Construir o pacote com maven local
.PHONY: clean
clean:
	find . -name "pom.xml" -exec mvn versions:set -DnewVersion=${VERSION} -f '{}' \;
	find . -name "pom.xml" -exec mvn clean package -f '{}' \;

## Construir o pacote com maven
#.PHONY: clean
#clean:
#	$(call docker-run,find . -name "pom.xml" -exec mvn versions:set -DnewVersion=${VERSION} -f '{}' \;)
#	$(call docker-run,find . -name "pom.xml" -exec mvn clean package -f '{}' \;)

## Criar imagens do docker da aplicacao
.PHONY: images
images:
	@echo "Generating docker image for eurekaserver"
	docker build -f eurekaserver/Dockerfile -t eurekaserver:${VERSION} --build-arg VERSION=${VERSION} --build-arg JAR_FILE=eurekaserver/target/*.jar .
	@echo "Generating docker image for zuulserver"
	docker build -f zuulserver/Dockerfile -t zuulserver:${VERSION} --build-arg VERSION=${VERSION} --build-arg JAR_FILE=eurekaserver/target/*.jar .
	@echo "Generating docker image for movieservice"
	docker build -f movieservice/Dockerfile -t movieservice:${VERSION} --build-arg VERSION=${VERSION} --build-arg JAR_FILE=movieservice/target/*.jar .
	@echo "Generating docker image for userservice"
	docker build -f userservice/Dockerfile -t userservice:${VERSION} --build-arg VERSION=${VERSION} --build-arg JAR_FILE=userservice/target/*.jar .
	@echo "Generating docker image for kafka"
	docker build -f kafka/Dockerfile -t kafka:${VERSION} .
	@echo "Generating docker image for zookeeper"
	docker build -f zookeeper/Dockerfile -t zookeeper:${VERSION} .

run:
	cp compose-file docker-compose.yml
	sed -i 's/{VERSION}/${VERSION}/g' docker-compose.yml
	docker-compose up -d

## Rodar o build e subir aplicacao (WiP)
#.PHONY: up
#up: clean images run

## Executar stack em docker-compose
.PHONY: install
install: clean images run

## Aprentacao deste help
.PHONY: help
help:
	@awk '/^.PHONY: / { \
		msg = match(lastLine, /^## /); \
			if (msg) { \
				cmd = substr($$0, 9, 100); \
				msg = substr(lastLine, 4, 1000); \
				printf "  ${GREEN}%-30s${RESET} %s\n", cmd, msg; \
			} \
	} \
	{ lastLine = $$0 }' $(MAKEFILE_LIST)

quiet-command = $(if ${V},${1},$(if ${2},@echo ${2} && ${1}, @${1}))
docker-run    = $(call quiet-command,${DOCKER_RUN_CMD} ${1} | cat,"${YELLOW}[RUNNING TASK IN DOCKER] ${GREEN}${1}${RESET}")

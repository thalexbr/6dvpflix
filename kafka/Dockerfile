FROM ubuntu

RUN apt-get update

RUN apt-get install -y wget

RUN apt-get install -y openjdk-11-jre-headless

RUN wget https://downloads.apache.org/kafka/2.8.0/kafka_2.12-2.8.0.tgz

RUN tar xf kafka_2.12-2.8.0.tgz

RUN rm kafka_2.12-2.8.0.tgz

RUN mv kafka_2.12-2.8.0 kafka

ENV KAFKA_HOME=${PWD}/kafka

ENV PATH=${KAFKA_HOME}/bin:${PATH}

RUN sed -i 's/localhost:2181/zookeeper:2181/g' $KAFKA_HOME/config/server.properties

COPY startup.sh startup.sh

CMD ["bash","startup.sh"]


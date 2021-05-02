FROM ubuntu

RUN apt-get update

RUN apt-get install -y wget

RUN apt-get install -y openjdk-11-jre-headless

RUN wget http://ftp.unicamp.br/pub/apache/zookeeper/zookeeper-3.6.3/apache-zookeeper-3.6.3-bin.tar.gz

RUN tar xf apache-zookeeper-3.6.3-bin.tar.gz

RUN rm apache-zookeeper-3.6.3-bin.tar.gz

RUN mv apache-zookeeper-3.6.3-bin zk

ENV ZOOKEEPER_HOME=${PWD}/zk

ENV PATH=${ZOOKEEPER_HOME}/bin:${PATH}

RUN mv $ZOOKEEPER_HOME/conf/zoo_sample.cfg $ZOOKEEPER_HOME/conf/zoo.cfg

COPY zookeeper/startup.sh startup.sh

CMD ["bash","startup.sh"]

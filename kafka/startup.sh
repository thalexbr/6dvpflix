kafka-server-start.sh $KAFKA_HOME/config/server.properties &

sleep 20

kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic userEventTopic

while true; do { sleep 500; } done


# spring boot-kafka with docker
Step 1: Setup Docker
docker-compose.yaml has bellow service
so in docker-compose.yml file we have 4 services, namely zookeeper and kafka-server-1, kafka-server-2, manager.

Make the zookepper server always starts before 2 Kafka servers, Kafka manager triggered start or stop. So in the config of the we have a setup depends_on to this dependency.

Zookeeper server is listening on the port 2181 to manage our Kafka servers. We defined within the same container setup and for any client running on the host will be run on the port 22181 so in the config of the zookeeper, we will expose on the port 22181:2181

With 2 nodes of Kafka servers we will expose the host application with port 29092 & 39092. However our Kafka is actually advertised on the port 9092 configured in the environment

Step 2: Start services 
i) nc -z localhost 22181
ii) nc -z localhost 29092
iii) nc -z localhost 39092
iv) nc -z localhost 9000

docker-compose logs zookeeper | grep -i started

docker-compose logs kafka-server-1 | grep -i started

Step 3: CMAK is a tool for managing Apache Kafka clusters

Ref: https://haithai91.medium.com/zookeeper-kafka-with-docker-b1d4b33c0d5e
https://betterprogramming.pub/kafka-with-java-spring-and-docker-asynchronous-communication-between-microservices-e1d00e120831

1. run this project with port:8081
2. use postman to test make sure kafka already running
  2.1: from authorization tab 
      select Basic Auth from type drop down
      input: user as admin and password as password
  2.2: endpoint: http://localhost:8081/orders
  2.3: payload:
{
"customerName": "Norbert Bautista",
"customerEmail": "norbert.bautista@gmail.com",
"totalPrice": 100.50,
"products": [
{
"productId": 1,
"quantity": 2
},
{
"productId": 2,
"quantity": 1
}
]
}
3. h2 db link: localhost:8081/h2-console/
3.1: JDBC-URL: jdbc:h2:mem:manulifedb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE


===kafka===
using kafka version: kafka_2.13-3.7.0
using kafka version: kafka_2.13-3.7.0

run via git bash
1. bin/zookeeper-server-start.sh config/zookeeper.properties

2. bin/kafka-server-start.sh config/server.properties

3. bin/kafka-topics.sh --create --topic orders --bootstrap-server localhost:9092

4. bin/kafka-topics.sh --describe --topic orders --bootstrap-server localhost:9092

5. bin/kafka-console-producer.sh --topic orders --bootstrap-server localhost:9092

6. bin/kafka-console-consumer.sh --topic orders --from-beginning --bootstrap-server localhost:9092

note: details instructions at https://kafka.apache.org/quickstart
# hexlixlab-microservice

Build:<br>
mvn clean package<br>
mvn clean package -Dmaven.test.skip=true (without test)<br>

Run:<br>
start java -jar eureka/target/eureka-0.0.1-SNAPSHOT.jar<br>
start java -jar payment/target/payment-0.0.1-SNAPSHOT.jar<br>
start java -jar zuul/target/zuul-0.0.1-SNAPSHOT.jar<br>

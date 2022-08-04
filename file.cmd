## mvn clean install &
start java -jar .\discovery-service\target\discovery-service-0.0.1-SNAPSHOT.jar
start java -jar .\api-gateway\target\api-gateway-0.0.1-SNAPSHOT.jar
start java -jar .\temperatura-service\target\temperatura-service-0.0.1-SNAPSHOT.jar
start java -jar .\sonido-service\target\sonido-service-0.0.1-SNAPSHOT.jar

az spring-cloud app deploy -n api-gateway -s spring-cloud-fun -g spring-cloud-fun-group --jar-path ./api-gateway/target/api-gateway-0.0.1-SNAPSHOT.jar
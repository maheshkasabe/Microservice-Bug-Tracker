FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} apiGateway.jar
ENTRYPOINT ["java","-jar","/apiGateway.jar"]
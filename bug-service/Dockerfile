FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} bug-service.jar
ENTRYPOINT ["java","-jar","/bug-service.jar"]
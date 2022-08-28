# Microservice Application

### What is it?

The above Microservice Architecture is a Bug Tracker Application which includes =>

1. Creating a Project (Issue)
2. Assigning People to the Project
3. Adding / Defineinng Bug 

### Diagram 

![alt tag](https://github.com/Mahesh-Kasabe/Microservice-Devops-Project/blob/master/Images/diagram.png)

Below are the Screen-Shots of Application Components 


### Frontend 

![alt tag](https://github.com/Mahesh-Kasabe/Microservice-Devops-Project/blob/master/Images/SignIn.png?raw=true)

![alt tag](https://github.com/Mahesh-Kasabe/Microservice-Devops-Project/blob/master/Images/Project.png?raw=true)

![alt tag](https://github.com/Mahesh-Kasabe/Microservice-Devops-Project/blob/master/Images/Bug.png?raw=true)

### Api-Gateway (Spring Cloud Gateway)


Configuration : 

```
spring:
  application:
    name: API-GATEWAY
  cloud:
    gateway:
      default-filters:
        - DedupeResponseHeader=Access-Control-Allow-Credentials Access-Control-Allow-Origin
      globalcors:
        corsConfigurations:
          '[/**]':
            allowedOrigins: "*"
            allowedHeaders: "*"
            allowedMethods: "*"
      routes:
        - id: USER-SERVICE
          uri: lb://USER-SERVICE
          predicates:
            - Path=/users/**
        - id: PROJECT-SERVICE
          uri: lb://PROJECT-SERVICE
          predicates:
            - Path=/projects/**
        - id: BUG-SERVICE
          uri: lb://BUG-SERVICE
          predicates:
            - Path=/bugs/**
```

### Service Registry (Netflix Eureka Client)

![alt tag](https://github.com/Mahesh-Kasabe/Microservice-Devops-Project/blob/master/Images/ServiceRegistry.png?raw=true)


### MessageQ (Async Communication between BugService and ProjectService)


![alt tag](https://github.com/Mahesh-Kasabe/Microservice-Devops-Project/blob/master/Images/MQ1.png?raw=true)

![alt tag](https://github.com/Mahesh-Kasabe/Microservice-Devops-Project/blob/master/Images/MQ2.png?raw=true)

![alt tag](https://github.com/Mahesh-Kasabe/Microservice-Devops-Project/blob/master/Images/MQ3.png?raw=true)


### Logging 

![alt tag](https://github.com/Mahesh-Kasabe/Microservice-Devops-Project/blob/master/Images/Log.png?raw=true)

### Technology

* [SpringBoot] - Application framework
* [Spring-Cloud-Gateway] - API Gateway (Load Balancer)
* [Eureka] - Service registration and Discovery
* [Docker] - Image containerization
* [Kuberntes] -  container orchestration engine .
* [RabbitMQ] - asynchronous  messaging.
* [Logstash] - Log collector
* [Elasticsearch] - Log indexer
* [Kibana] - Data visualization
* [React] - Frontend






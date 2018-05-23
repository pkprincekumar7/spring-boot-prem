# SpringBootWorkShop
SpringBoot Workshop code

## SpringBoot Features
  * Web Development
  * SpringApplication
  * Properties Files
  * YAML Support
  * Logging
  
### Spring Boot Starters
Spring Boot provides built-in starters which makes development easier and rapid. Below is the list of few starter included in POC.

  * spring-boot-starter-web
  * spring-cloud-starter-zuul
  * spring-boot-starter-test
  * spring-boot-starter-data-jpa
  * spring-cloud-starter-eureka-server
  * spring-cloud-starter-sleuth
  * spring-cloud-starter-eureka
  
  ## Architecture for Demo Application
  
![microservice](https://user-images.githubusercontent.com/10416881/36396189-c2405d22-15e2-11e8-8866-4ae8ed5792c0.png)

#### spring-cloud-starter-zuul
Zuul is the front door for all requests from devices and web sites to the backend of the Netflix streaming application. 

#### spring-cloud-starter-eureka-server
The Eureka server is nothing but a service discovery pattern implementation, where every microservice is registered and a     client microservice looks up the Eureka server to get a dependent microservice to get the job done.  The Eureka Server is a Netflix OSS product, and Spring Cloud offers a declarative way to register and invoke services by Java annotation.

#### Eureka Server/Client Communication
Every microservice registers itself in the Eureka server when bootstrapped, generally using the {ServiceId} it registers into the Eureka server, or it can use the hostname or any public IP (if those are fixed). After registering, every 30 seconds, it pings the Eureka server to notify it that the service itself is available. If the Eureka server not getting any pings from a service for a quite long time, this service is unregistered from the Eureka server automatically and the Eureka server notifies the new state of the registry to all other services

#### Spring Cloud Sleuth
Spring Cloud Sleuth is meant to help with this exact problem. It introduces unique IDs to your logging which are consistent between microservice calls which makes it possible to find how a single request travels from one microservice to the next.

Spring Cloud Sleuth adds two types of IDs to your logging, one called a trace ID and the other called a span ID. The span ID represents a basic unit of work, for example sending an HTTP request. The trace ID contains a set of span IDs, forming a tree-like structure. The trace ID will remain the same as one microservice calls the next. Let's take a look at a simple example which uses Spring Cloud Sleuth to trace a request.

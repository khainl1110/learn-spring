# learn-spring
## This is a project building microservices using spring cloud and spring boot
- EurekaService is netflix eureka server for discovery. Other services will register will eureka so eureka needs to launch first. 
- APIGateway is routing layer and acts as load balancer which can route to other microservices. APIGateway needs to launch second
- AppAppiUsers contains api for users sign up, log in. Consists of following packages:
  - ui packages, which contain the representation layer, consist of controllers and model package
  - service package, which contains the service layer
  - share package

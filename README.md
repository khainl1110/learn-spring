# learn-spring
## This is a project building microservices using spring cloud and spring boot
- EurekaService is netflix eureka server for discovery. Other services will register will eureka so eureka needs to launch first. 
- APIGateway is routing layer and acts as load balancer which can route to other microservices. APIGateway needs to launch second
- AppAppiUsers contains api for users sign up, log in. Consists of following packages:

## AppApiUsers architecture
- Logic flow (3 tier architecture): Controller -> Service -> UsersRepository
 - Controller is the REST API, Service is logic layer while UsersRepository is data store layer 
- Data path:  CreateUserRequestModel -> UserDto(UserDataTransferObject) -> UserEntity
 - Rest API accept CreateUserRequestModel, which then passes to UserDto for logic processing then finally to UserEntity to save object
 - Convert data from one class to another using ModelMapper
 - UserDto will encrypt the password as well as setting userId, which is randomly generated for public request   
 - UserEntity will have long id using as key in the table

For now, only 1 API endpoint works, /users for get and post, corresponding to get all the users and create new user. Please refer to UsersController to see the API endpoints.
   

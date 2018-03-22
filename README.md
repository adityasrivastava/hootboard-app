# Spring Sample application

Token based api for users crud operation with token based login and RestFul transaction

### Features
  - Authentication server
  - Resource server
  - Spring 5
  - Spring data Jpa with Mysql integration
  - CRUD operation for users 
  - User registers and create N - number of users for its team



### Steps To setup :

  - Root project > run > mvn clean install 
  - cd to authentication-server and run command 'mvn spring-boot:run'
  - then cd to resource-server(api-server) and run command 'mvn spring-boot:run'
  - once both server are up and running you can use the API docs link provided to make API requests
  - Also in root directory 'hootboard.postman_collection.json' you can import into postman and make requests
  
### Requirements :
    - Mysql 
    - Java 8
    - Maven
### Notes:
Mysql password and details can be configured as below:
- persistence-service/src/main/resources/mysql-persistence.properties


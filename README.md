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

### API : Please refer to POSTMAN for more API details
    - GET : localhost:8100/register
    - POST : http://localhost:8100/oauth/token?username={{username}}&password={{password}}&grant_type=password
    - POST : localhost:8200/api/v1/users
    - PUT : localhost:8200/api/v1/users/1
    - GET : localhost:8200/api/v1/users?page=0&size=10
    - DELETE : localhost:8200/api/v1/users/1

### Requirements :
    - Mysql 
    - Java 8
    - Maven
### Docker
    - If you have trouble in setup you can also use
        - 1. change localhost to hootboard-mysql in mysql-persistence.properties
        - 2. cd to docker dir
        - 3. mkdir -p db/mysql
        - 4. mkdir shared
        - 5. docker-compose up --build
## for docker download maven & jdk 8 and place in tools folder (Github has size limit so could not add)
### PostMan:
    - Chrome extension
    - import files hootboard.postman_collection.json & hootboard-app.postman_environment.json
### Notes:
Mysql password and details can be configured as below:
- persistence-service/src/main/resources/mysql-persistence.properties


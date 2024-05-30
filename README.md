# springboot-mongodb-demo
A demo project showcasing Spring Boot with MongoDB integration.

## Run Locally

Clone the project

```bash
  git clone https://github.com/albatranomar/springboot-mongodb-demo.git
```

Go to the project directory

```bash
  cd springboot-mongodb-demo
```

Start mongodb server (Docker)

```bash
  run -d --name mongo-demo -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=adminadmin -p 27017:27017 -v mongodemo:/data/db mongo:7.0
```
* MONGO_INITDB_ROOT_USERNAME: mongoadmin
* MONGO_INITDB_ROOT_PASSWORD: adminadmin

Update your `application.properties` to match this

 ```properties
spring.application.name=demonosql

spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=demoSpring
spring.data.mongodb.username=mongoadmin
spring.data.mongodb.password=adminadmin
spring.data.mongodb.authentication-database=admin
```

You are ready to go!
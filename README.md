# mobilab-full-stack-dev-tasks

## Introduction
This repository contains a simple Account Management Service to define bank accounts and perform money transactions between them with the functionality of currency conversion.

## Build and Run
This project uses Maven as its build tool. To build this project, run this maven command:
```
mvn clean package
```
The Maven build creates an executable jar. You can start the application with:
```
java -jar mobilab-full-stack-dev-tasks-0.0.1-SNAPSHOT.jar
```

## Containerize It
There is a `Dockerfile` in this project, in order to build a Docker image. You can run it with:

```
docker build -t mobilab-image .
```

## REST API documentation
REST API documentation is generated using SpringDoc. SpringDoc is a tool that simplifies the generation and maintenance of API docs, based on the OpenAPI 3 specification and Swagger. After running the project, API documentation will be available at [http://localhost:8080/swagger-ui-custom.html](http://localhost:8080/swagger-ui-custom.html)


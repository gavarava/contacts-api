# Contacts Application [![Build Status](https://travis-ci.org/gavarava/contacts-app.svg?branch=master)](https://travis-ci.org/gavarava/contacts-app)  

A simple Microservice to List, Add, Delete contacts using Dropwizard framework.

How to start the Contacts application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/contacts-app-0.1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

Run Postgres Database using docker
--- 
```shell script
docker run --rm -it -p 5432:5432 -e POSTGRES_PASSWORD=secret postgres:9.6-alpine
```
Spring Boot Coding Dojo
---
### Build

```shell script
./mvnw clean install
```
### How to run

1. First execute the following command to create initial schema:

```shell script
./mvnw clean flyway:migrate \
  -Dflyway.url=jdbc:postgresql://localhost:5432/openw \
  -Dflyway.locations=filesystem:src/main/resources/data \
  -Dflyway.user=test \
  -Dflyway.password=test
```
2. Then run the following command to run the service:
```shell script
./mvnw spring-boot:run \
  -Ddb.url=jdbc:postgresql://localhost:5432/openw \
  -Ddb.username=test \
  -Ddb.password=test \
  -Dopen-weather.appId=<openweather_api_key>
```

3. Finally, you can test the service with the following url:
`http://localhost:8080/weather?city=Amsterdam`

---

Welcome to the Spring Boot Coding Dojo!

### Introduction

This is a simple application that requests its data from [OpenWeather](https://openweathermap.org/) and stores the result in a database. The current implementation has quite a few problems making it a non-production ready product.

### The task

As the new engineer leading this project, your first task is to make it production-grade, feel free to refactor any piece
necessary to achieve the goal.

### How to deliver the code

Please send an email containing your solution with a link to a public repository.

>**DO NOT create a Pull Request with your solution** 

### Footnote
It's possible to generate the API key going to the [OpenWeather Sign up](https://openweathermap.org/appid) page.

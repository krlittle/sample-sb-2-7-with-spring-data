# sample-sb-2-7-with-spring-data

Saves, reads and deletes notes over REST.

## Stack

- Spring Boot 2.7.18
- Java 17
- Gradle 8.4

## Build

```
./gradlew build
```

## Run

```
./gradlew bootRun
```

```
curl -X POST localhost:8080/notes -H 'Content-Type: application/json' -d '{"text":"buy milk"}'
curl localhost:8080/notes/1
curl -X DELETE localhost:8080/notes/1
```

# quicksort REST application

REST application which implements the quicksort algorithm, developed thanks to Quarkus.

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.10.1.Final:create -DprojectGroupId=local.example -DprojectArtifactId=quicksort -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="resteasy-jackson"
```

## run application in development mode

```shell
./mvnw quarkus:dev
```

## examples of use

### POST http method

```shell
curl -i -X POST -H "Content-Type: application/json" -d '{"items":[{"key":18,"name":"eighteen"},{"key":7,"name":"seven"},{"key":7,"name":"seven"},{"key":12,"name":"twelve"},{"key":4,"name":"four"}]}' http://127.0.0.1:8080/outcome/sorting
HTTP/1.1 200 OK
Content-Type: application/json
content-length: 478

[{"items":[{"key":1,"name":"one"},{"key":2,"name":"two"},{"key":3,"name":"three"},{"key":4,"name":"four"},{"key":5,"name":"five"},{"key":7,"name":"seven"}]},{"items":[{"key":1,"name":"one"},{"key":2,"name":"two"},{"key":3,"name":"three"},{"key":4,"name":"four"},{"key":5,"name":"five"},{"key":6,"name":"six"},{"key":7,"name":"seven"}]},{"items":[{"key":4,"name":"four"},{"key":7,"name":"seven"},{"key":7,"name":"seven"},{"key":12,"name":"twelve"},{"key":18,"name":"eighteen"}]}]
```

### GET http method

```shell
curl -i http://127.0.0.1:8080/outcome/items
HTTP/1.1 200 OK
Content-Type: application/json
content-length: 478

[{"items":[{"key":1,"name":"one"},{"key":2,"name":"two"},{"key":3,"name":"three"},{"key":4,"name":"four"},{"key":5,"name":"five"},{"key":7,"name":"seven"}]},{"items":[{"key":1,"name":"one"},{"key":2,"name":"two"},{"key":3,"name":"three"},{"key":4,"name":"four"},{"key":5,"name":"five"},{"key":6,"name":"six"},{"key":7,"name":"seven"}]},{"items":[{"key":4,"name":"four"},{"key":7,"name":"seven"},{"key":7,"name":"seven"},{"key":12,"name":"twelve"},{"key":18,"name":"eighteen"}]}]
```

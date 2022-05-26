# radixsort

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.9.2.Final:create -DprojectGroupId=local.example -DprojectArtifactId=radixsort -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="resteasy-jackson"
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
content-length: 143

[{"items":[{"key":4,"name":"four"},{"key":7,"name":"seven"},{"key":7,"name":"seven"},{"key":12,"name":"twelve"},{"key":18,"name":"eighteen"}]}]
```

### GET http method

```shell
curl -i http://127.0.0.1:8080/outcome/items
HTTP/1.1 200 OK
Content-Type: application/json
content-length: 143

[{"items":[{"key":4,"name":"four"},{"key":7,"name":"seven"},{"key":7,"name":"seven"},{"key":12,"name":"twelve"},{"key":18,"name":"eighteen"}]}]
```

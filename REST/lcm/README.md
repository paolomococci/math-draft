# lcm (Least Common Multiple)

REST application template developed thanks to Quarkus.

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.12.1.Final:create -DprojectGroupId=local.example -DprojectArtifactId=lcm -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="resteasy-jackson"
```

## run application in development mode

```shell
./mvnw quarkus:dev
```

## examples of using this API with curl

we start with the GET method when the computation list is still empty

```shell
curl -i http://127.0.0.1:8080/outcome
```

response:

```text
HTTP/1.1 200 OK
content-length: 0
```

let's continue with the first request made with the POST method

```shell
curl -i -X POST -H "Content-Type: application/json" -d '{"a":405,"b":450}' http://127.0.0.1:8080/outcome
```

response:

```text
HTTP/1.1 200 OK
Content-Type: application/json
content-length: 30

[{"a":405,"b":450,"lcm":4050}]
```

again, a request made with the POST method

```shell
curl -i -X POST -H "Content-Type: application/json" -d '{"a":570,"b":1482}' http://127.0.0.1:8080/outcome
```

response:

```text
HTTP/1.1 200 OK
Content-Type: application/json
content-length: 60

[{"a":405,"b":450,"lcm":4050},{"a":570,"b":1482,"lcm":7410}]
```

one more request with the GET method, now the computation list contains two objects

```shell
curl -i http://127.0.0.1:8080/outcome
```

response:

```text
HTTP/1.1 200 OK
Content-Type: application/json
content-length: 60

[{"a":405,"b":450,"lcm":4050},{"a":570,"b":1482,"lcm":7410}]
```

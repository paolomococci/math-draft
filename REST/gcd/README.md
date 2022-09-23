# gcd (Greatest Common Divisor)

REST application template developed thanks to Quarkus.

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.12.3.Final:create -DprojectGroupId=local.example -DprojectArtifactId=gcd -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="resteasy-jackson" -DbuildTool=gradle
```

## run application in development mode

```shell
./gradlew quarkusDev
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
curl -i -X POST -H "Content-Type: application/json" -d '{"a":20,"b":125}' http://127.0.0.1:8080/outcome
```

response:

```text
HTTP/1.1 200 OK
Content-Type: application/json
content-length: 26

[{"a":20,"b":125,"gcd":5}]
```

again, a request made with the POST method

```shell
curl -i -X POST -H "Content-Type: application/json" -d '{"a":34,"b":4040}' http://127.0.0.1:8080/outcome
```

response:

```text
HTTP/1.1 200 OK
Content-Type: application/json
content-length: 52

[{"a":20,"b":125,"gcd":5},{"a":34,"b":4040,"gcd":2}]
```

one more request with the GET method, now the computation list contains two objects

```shell
curl -i http://127.0.0.1:8080/outcome
```

response:

```text
HTTP/1.1 200 OK
Content-Type: application/json
content-length: 52

[{"a":20,"b":125,"gcd":5},{"a":34,"b":4040,"gcd":2}]
```

# eoq

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.15.2.Final:create -DprojectGroupId=local.example -DprojectArtifactId=eoq -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="resteasy-jackson" -DbuildTool=gradle
```

## to run in development mode

```shell
./gradlew quarkusDev
```

## example of using this API with curl

As soon as the application is started, I can start with the GET method which, at first, does not return any Eoq objects

```shell
curl -i http://127.0.0.1:8080/outcome
```

the system responds:

```text
HTTP/1.1 200 OK
content-length: 0
```

Now I try to post a first Eoq object in json format:

```shell
curl -i -X POST -H "Content-Type: application/json" -d '{"demand":2000,"costOfIssuing":125,"price":23,"interestRate":0.1}' http://127.0.0.1:8080/outcome
```

and the system responds with a first solution:

```text
HTTP/1.1 200 OK
Content-Type: application/json
content-length: 117

[{"id":"0","demand":2000.0,"costOfIssuing":125.0,"price":23.0,"interestRate":0.1,"quantity":466,"ordersToProcess":4}]
```

I try to pass a new object:

```shell
curl -i -X POST -H "Content-Type: application/json" -d '{"demand":20000,"costOfIssuing":210,"price":1650,"interestRate":0.25}' http://127.0.0.1:8080/outcome
```

system respond with an array of Eoq objects in json format:

```text
HTTP/1.1 200 OK
Content-Type: application/json
content-length: 239

[{"id":"0","demand":2000.0,"costOfIssuing":125.0,"price":23.0,"interestRate":0.1,"quantity":466,"ordersToProcess":4},{"id":"1","demand":20000.0,"costOfIssuing":210.0,"price":1650.0,"interestRate":0.25,"quantity":143,"ordersToProcess":140}]
```

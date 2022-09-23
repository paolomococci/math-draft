# eoq-stock (Economic Order Quantity)

In this case, I have considered separately the financial charges for the fixed capital and the live cost of maintaining the stock.

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.12.3.Final:create -DprojectGroupId=local.example -DprojectArtifactId=eoq-stock -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="resteasy-jackson" -DbuildTool=gradle
```

## I start the application in development mode

```shell
./gradlew quarkusDev
```

## now I try to post a first Eoq object in json format:

```shell
curl -i -X POST -H "Content-Type: application/json" -d '{"demand":800,"costOfIssuing":14,"price":73,"interestRate":0.12,"costOfStock":1}' http://127.0.0.1:8080/outcome
```

getting:

```text
HTTP/1.1 200 OK
Content-Type: application/json
content-length: 125

[{"demand":800.0,"costOfIssuing":14.0,"price":73.0,"interestRate":0.12,"costOfStock":1.0,"quantity":46,"ordersToProcess":17}]
```

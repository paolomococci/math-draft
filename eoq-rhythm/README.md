# eoq-rhythm (Economic Order Quantity)

EOQ applied to production rate.

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.10.2.Final:create -DprojectGroupId=local.example -DprojectArtifactId=eoq-rhythm -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="resteasy-jackson" -DbuildTool=gradle
```

## I start the application in development mode

```shell
./gradlew quarkusDev
```

## now I try to post a first Eoq object in json format:

```shell
curl -i -X POST -H "Content-Type: application/json" -d '{"demand":91000,"setUpCost":4.8,"interestRate":0.12,"stockCost":0.5,"productionCost":0.5,"productionRateInMinutes":0.347222222}' http://127.0.0.1:8080/outcome
```

getting the following answer:

```text

```

# eoq-safety-rc1 (Economic Order Quantity with Safety Stock)

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.16.5.Final:create -DprojectGroupId=local.example -DprojectArtifactId=eoq-safety-rc1 -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="kotlin,resteasy-reactive-jackson" -DbuildTool=gradle
```

## I start the application in development mode

```shell
./gradlew quarkusDev
```

## please note

```text
Defined as a percentage of service level, the value for the "service level key" is obtained from the tables of the standardized variable.
```

For example, if you want a service level around 95%. 
That is, if you want to avoid falling into a stock-out in ninety-five percent of cases, serviceLevelKey will have a value of 1.65.

If you want a service level around 98%.
That is, if you want to avoid falling into a stock-out in ninety-eight percent of cases, serviceLevelKey will have a value of 2.06.

If you want a service level around 99%.
That is, if you want to avoid falling into a stock-out in ninety-nine percent of cases, serviceLevelKey will have a value of 2.33.

If you want a service level around 99,9%.
That is, if you want to avoid falling into a stock-out in nine hundred ninety-nine per thousand of cases, serviceLevelKey will have a value of 3.09.

## now I try to post a first Eoq object in json format:

```shell
curl -i -X POST -H "Content-Type: application/json" -d '{"demand":43800,"standardDeviationPerDay":100.6,"procurementLeadTime":9,"serviceLevelKey":2.06,"costOfIssuing":14,"price":73,"interestRate":0.12,"costOfStock":1}' http://127.0.0.1:8080/outcome
```

getting:

```text
HTTP/1.1 200 OK
content-length: 257
Content-Type: application/json;charset=UTF-8

[{"id":"0","demand":43800.0,"standardDeviationPerDay":100.6,"procurementLeadTime":9.0,"serviceLevelKey":2.06,"costOfIssuing":14.0,"price":73.0,"interestRate":0.12,"costOfStock":1.0,"quantity":338,"ordersToProcess":130,"safetyStock":622,"reorderLevel":1702}]
```

# eoq-safety-rc1

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.11.1.Final:create -DprojectGroupId=local.example -DprojectArtifactId=eoq-safety-rc1 -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="kotlin,resteasy-reactive-jackson" -DbuildTool=gradle
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
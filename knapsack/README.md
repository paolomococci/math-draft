# knapsack

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.7.2.Final:create -DprojectGroupId=local.example -DprojectArtifactId=knapsack -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="resteasy-jackson"
```

## run application in development mode

```shell
./mvnw quarkus:dev
```

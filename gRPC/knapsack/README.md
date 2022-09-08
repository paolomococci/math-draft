# knapsack 

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.12.1.Final:create -DprojectGroupId=local.example -DprojectArtifactId=knapsack -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="kotlin,quarkus-resteasy-reactive" -DbuildTool=gradle
```

## run application in development mode

```shell
./gradlew quarkusDev
```

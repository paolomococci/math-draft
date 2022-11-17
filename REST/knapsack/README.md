# knapsack

In this REST application example, I look at 0-1 knapsack problem, which consists of need to choose the items whose total weight does not exceed the weight limit and the total value is as high as possible, it being understood that each item can be chosen only once.

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.14.1.Final:create -DprojectGroupId=local.example -DprojectArtifactId=knapsack -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="resteasy-jackson"
```

## run application in development mode

```shell
./mvnw quarkus:dev
```

# eoq-safety-rc2  (Economic Order Quantity with Safety Stock)

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.11.3.Final:create -DprojectGroupId=local.example -DprojectArtifactId=eoq-safety-rc2 -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="kotlin,resteasy-reactive-jackson" -DbuildTool=gradle
```

## I start the application in development mode

```shell
./gradlew quarkusDev
```
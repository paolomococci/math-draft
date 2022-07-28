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

# eoq-safety-rc3 

In this version I will consider only 220 working days in a year.

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.11.3.Final:create -DprojectGroupId=local.example -DprojectArtifactId=eoq-safety-rc3 -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="kotlin,resteasy-reactive-jackson" -DbuildTool=gradle
```

## I start the application in development mode

```shell
./gradlew quarkusDev
```

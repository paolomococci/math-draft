# eoq-safety-rc4

Also in this version I will consider only 220 working days in a year.

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.16.5.Final:create -DprojectGroupId=local.example -DprojectArtifactId=eoq-safety-rc4 -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="kotlin,resteasy-reactive-jackson" -DbuildTool=gradle
```

## I start the application in development mode

```shell
./gradlew quarkusDev
```

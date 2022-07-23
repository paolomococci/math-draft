# average 

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.10.3.Final:create -DprojectGroupId=local.example -DprojectArtifactId=average -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="kotlin,resteasy-reactive-jackson" -DbuildTool=gradle
```

## running in development mode

```shell
./gradlew quarkusDev
```

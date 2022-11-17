# geometric-mean 

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.14.1.Final:create -DprojectGroupId=local.example -DprojectArtifactId=geometric-mean -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="kotlin,resteasy-reactive-jackson" -DbuildTool=gradle
```

## running in development mode

```shell
./gradlew quarkusDev
```

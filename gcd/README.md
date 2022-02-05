# gcd (GreatestCommonDivisor)

REST application template developed thanks to Quarkus.

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.7.0.Final:create -DprojectGroupId=local.example -DprojectArtifactId=gcd -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="resteasy-jackson" -DbuildTool=gradle
```

## run application in development mode

```shell
./gradlew quarkusDev
```

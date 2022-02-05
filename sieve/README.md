# sieve (Sieve of Eratosthenes)

REST application template developed thanks to Quarkus.

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.7.0.Final:create -DprojectGroupId=local.example -DprojectArtifactId=sieve -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="resteasy-jackson"
```

## run application in development mode

```shell
./mvnw quarkus:dev
```

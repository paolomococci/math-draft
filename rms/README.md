# rms (Root Mean Square)

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.11.1.Final:create -DprojectGroupId=local.example -DprojectArtifactId=rms -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="kotlin,resteasy-reactive-jackson" -DbuildTool=gradle
```

## running in development mode

```shell
./gradlew quarkusDev
```

## I tried to send the following data

```shell
curl -i -X POST -H "Content-Type: application/json" -d '{"values":[40,-700,780,850,880,-970,1000,-1200]}' http://127.0.0.1:8080/outcome
```

### and I got the following answer

```text

```

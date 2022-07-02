# eoq

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.10.1.Final:create -DprojectGroupId=local.example -DprojectArtifactId=eoq -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="resteasy-jackson" -DbuildTool=gradle
```

## to run in development mode

```shell
./gradlew quarkusDev
```

## example of using this API with curl

I can start with the GET method which simply returns a string of feedback

```shell
curl -i http://127.0.0.1:8080/outcome
```

# average 

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.16.5.Final:create -DprojectGroupId=local.example -DprojectArtifactId=average -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="kotlin,resteasy-reactive-jackson" -DbuildTool=gradle
```

## running in development mode

```shell
./gradlew quarkusDev
```

## now I try to post a first Average object in json format:

```shell
curl -i -X POST -H "Content-Type: application/json" -d '{"values":[2.3,7.1,3.5,6.2,9.0]}' http://127.0.0.1:8080/outcome
```

getting:

```text
HTTP/1.1 200 OK
content-length: 57
Content-Type: application/json;charset=UTF-8

[{"values":[2.3,7.1,3.5,6.2,9.0],"mu":5.619999999999999}]
```

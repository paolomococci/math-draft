# standard-deviation 

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.11.1.Final:create -DprojectGroupId=local.example -DprojectArtifactId=standard-deviation -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="kotlin,resteasy-reactive-jackson" -DbuildTool=gradle
```

## running in development mode

```shell
./gradlew quarkusDev
```

## now I try to post a first Sigma object in json format:

```shell
curl -i -X POST -H "Content-Type: application/json" -d '{"values":[2.3,7.1,3.5,6.2,9.0]}' http://127.0.0.1:8080/outcome
```

```text
HTTP/1.1 200 OK
content-length: 83
Content-Type: application/json;charset=UTF-8

[{"values":[2.3,7.1,3.5,6.2,9.0],"mu":5.619999999999999,"sigma":2.427673783686762}]
```

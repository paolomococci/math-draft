# harmonic-mean 

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.16.3.Final:create -DprojectGroupId=local.example -DprojectArtifactId=harmonic-mean -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="kotlin,resteasy-reactive-jackson" -DbuildTool=gradle
```

## running in development mode

```shell
./gradlew quarkusDev
```

## I tried to send the following data

```shell
curl -i -X POST -H "Content-Type: application/json" -d '{"values":[40,700,780,850,880,970,1000,1200]}' http://127.0.0.1:8080/outcome
```

### and I got the following answer

```text
HTTP/1.1 200 OK
content-length: 83
Content-Type: application/json;charset=UTF-8

[{"values":[40.0,700.0,780.0,850.0,880.0,970.0,1000.0,1200.0],"harmonicMu":243.25}]
```

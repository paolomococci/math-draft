# eoq-discount  (Economic Order Quantity)

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.10.1.Final:create -DprojectGroupId=local.example -DprojectArtifactId=eoq-discount -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="resteasy-jackson" -DbuildTool=gradle
```

## I start the application in development mode

```shell
./gradlew quarkusDev
```

### if I now try:

```shell
curl -i http://127.0.0.1:8080/outcome
```

## I get:

```text
curl -i http://127.0.0.1:8080/outcome
HTTP/1.1 200 OK
Content-Type: text/plain;charset=UTF-8
content-length: 16

feedback string
```

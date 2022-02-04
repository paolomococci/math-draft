# template

REST application template developed thanks to Quarkus.

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.7.0.Final:create -DprojectGroupId=local.example -DprojectArtifactId=template -DclassName="local.example.template.TemplateResource" -Dpath="/template" -Dextensions="quarkus-resteasy-reactive,quarkus-resteasy-reactive-jackson,quarkus-reactive-routes" -DbuildTool=gradle
```

## run application in development mode

```shell
./gradlew quarkusDev
```

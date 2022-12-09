# sample-grpc 

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.14.3.Final:create -DprojectGroupId=local.example -DprojectArtifactId=sample-grpc -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="kotlin,quarkus-resteasy-reactive" -DbuildTool=gradle
```

## compile

```shell
./gradlew quarkusGenerateCodeDev
```

## important: add the following plugin to the build.gradle file to be able to index the newly generated dependencies

```text
id "org.kordamp.gradle.jandex" version "1.0.0"
```

## run application in development mode

```shell
./gradlew quarkusDev
```

# eoq-stock (Economic Order Quantity)

In this case, I have considered separately the financial charges for the fixed capital and the live cost of maintaining the stock.

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.10.1.Final:create -DprojectGroupId=local.example -DprojectArtifactId=eoq-stock -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="resteasy-jackson" -DbuildTool=gradle
```

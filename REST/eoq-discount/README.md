# eoq-discount  (Economic Order Quantity)

In case the price depends on the quantity purchased.

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.12.3.Final:create -DprojectGroupId=local.example -DprojectArtifactId=eoq-discount -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="resteasy-jackson" -DbuildTool=gradle
```

## I start the application in development mode

```shell
./gradlew quarkusDev
```

## now I try to post a first Eoq object in json format:

```shell
curl -i -X POST -H "Content-Type: application/json" -d '{"demand":800,"costOfIssuing":14,"price":73,"discounts":[0.0,0.9,0.12,0.15],"minPurchase":[0,50,80,100],"interestRate":0.12,"costOfStock":1}' http://127.0.0.1:8080/outcome
```

getting:

```text
HTTP/1.1 200 OK
Content-Type: application/json
content-length: 285

[{"demand":800.0,"costOfIssuing":14.0,"price":73.0,"discounts":[0.0,0.9,0.12,0.15],"minPurchase":[0,50,80,100],"interestRate":0.12,"costOfStock":1.0,"quantity":[46,88,48,49],"ordersToProcess":[17,9,17,16],"validityOfTheMinPurchaseQuantity":[true,true,false,false],"diff":[18,8,16,16]}]
```

The best choice is the one with a lower diff value, always if a validity equal to true corresponds to it.

# sieve (Sieve of Eratosthenes)

REST application template developed thanks to Quarkus.

## scaffolding

```shell
mvn io.quarkus.platform:quarkus-maven-plugin:2.8.2.Final:create -DprojectGroupId=local.example -DprojectArtifactId=sieve -DclassName="local.example.outcome.OutcomeResource" -Dpath="/outcome" -Dextensions="resteasy-jackson"
```

## run application in development mode

```shell
./mvnw quarkus:dev
```

## examples of using this API with curl

we start with the GET method when the computation list is still empty

```shell
curl -i http://127.0.0.1:8080/outcome
```

response:

```text
HTTP/1.1 200 OK
content-length: 0
```

let's continue with the first request made with the POST method

```shell
curl -i -X POST -H "Content-Type: application/json" -d '{"top":10}' http://127.0.0.1:8080/outcome
```

response:

```text
HTTP/1.1 200 OK
Content-Type: application/json
content-length: 31

[{"top":10,"primes":[2,3,5,7]}]
```

again, a request made with the POST method

```shell
curl -i -X POST -H "Content-Type: application/json" -d '{"top":100}' http://127.0.0.1:8080/outcome
```

response:

```text
HTTP/1.1 200 OK
Content-Type: application/json
content-length: 125

[{"top":10,"primes":[2,3,5,7]},{"top":100,"primes":[2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97]}]
```

one more request with the GET method, now the computation list contains two objects

```shell
curl -i http://127.0.0.1:8080/outcome
```

response:

```text
HTTP/1.1 200 OK
Content-Type: application/json
content-length: 125

[{"top":10,"primes":[2,3,5,7]},{"top":100,"primes":[2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97]}]
```

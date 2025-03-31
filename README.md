## A micronaut gRPC client app

This app is a client for the spring boot server app [here](https://github.com/leadtrip/sb-grpc-server).

If you're not using java 21 as default prefix any ./gradlew commands with:

`./gradlew Dorg.gradle.java.home=PATH-TO-A-JAVA-21-VERSION`

The proto definitions are stored in a private [repsy](https://repsy.io/) maven repo. \
To build this app you need to specify the credentials so the proto artefact can be fetched.
```
export REPSY_USERNAME="your_username"
export REPSY_PASSWORD="your_password"
./gradlew build
```
The associated repo is [proto-definitions](https://github.com/leadtrip/proto-definitions).

Fire up the app\
`./gradlew run`

Hit the REST API with something like the following, change the end name to whatever:\
`curl http://localhost:8099/api/sayHi/dave`
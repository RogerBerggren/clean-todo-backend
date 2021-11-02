# Clean Architecture Todo-Backend Example

## Description

This is a [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
implementation of the todo backend. The project uses [Project Jigsaw](https://openjdk.java.net/projects/jigsaw/)
to achieve modularity between components in the project.

Currently, this project uses spring boot in order to implement the  backend. It
would have been interesting to do another backend implementation in parallel,
but time will not allow that for now. For example using the latest
[Jakarta EE](https://jakarta.ee/compatibility/#tab-9_1) specification or some
implementation of the MicroProfile to compare to the spring boot implementation
and also to ensure that the parts are really modularized could be a fun exercise
for someone that has time for that.

## Module dependencies

Below is a mermaid diagram that shows the modules used in this project and how they depend
on each other.

```mermaid
stateDiagram
    SpringApplication --> Config
    SpringApplication --> Controller
    Config --> JugGenerator
    Config --> UUIDGenerator
    Config --> SimpleDB
    Config --> HazelcastDB
    SpringApplication --> UseCase
    Controller --> UseCase
    Config --> UseCase
    JugGenerator --> UseCase
    UUIDGenerator --> UseCase
    SimpleDB --> UseCase
    HazelcastDB --> UseCase
    UseCase --> Domain
    Config --> Domain
    SimpleDB --> Domain
    HazelcastDB --> Domain
    Controller --> Domain
```

## Pre-requisite

Ensure Java 11 or higher is installed, the following version was
used when developing this project:

```shell
> java -version
openjdk version "12" 2019-03-19
OpenJDK Runtime Environment (build 12+33)
OpenJDK 64-Bit Server VM (build 12+33, mixed mode, sharing)
```

## Build, run and test

```shell
> ./gradlew clean build
> java -jar application/spring-app/build/libs/spring-app-1.0.0.jar
> ./gradlew test
```

After the spring application is started:
* Run the todobackend.com tests, [by following this link](https://todobackend.com/specs/index.html?http://localhost:8080/todos)
* Run the todobackend.com client, [by following this link](https://todobackend.com/client/index.html?http://localhost:8080/todos)

## Credits

First a thanks to Uncle Bob and his insights regarding clean architecture.
Please have a look at his [blog](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
for a more in depth explanation of what the Clean Architecture is all about.

Thank also to Carl-Philipp Harmant for his inspirational blog post on clean
architecture using Java 11. Brian Sayler also needs some credits for his spring-todo
example that was used to look at how a spring implementation of the todo framework
could look like.

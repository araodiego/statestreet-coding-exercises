# StateStreet Bank Coding Exercises

## Overview
This repository contains a series of coding exercises for State Street Bank, structured as a multi-module Maven project. Each module within this project represents a different coding challenge, showcasing Java programming skills, problem-solving abilities, and familiarity with Java stack

## Modules

- **Exercise 1: Divisibility Checker (`divisibility-checker`)**: A Java application that prints numbers from 1 to 20, applying specific rules for numbers divisible by 3 and 5. It uses Java Streams for processing and JUnit 5 for unit testing.
- **Exercise 2: Array Handler**: This module handles array operations. It takes a string input from the user, breaks it into an array of characters, sorts the array, and then combines the array back into a single sorted string.
- **Exercise 3: Person Management Service**: Spring Boot Web Application used to Search, Create, Read, Update and Delete the entity Person. 

## Prerequisites

- Java JDK 17 or later
- Maven 3.6.0 or later

## Building the Project

To build all modules in the project, navigate to the root directory and run:

```bash
mvn clean install
```
## Running Individual Modules

Running the Divisibility Checker:

```bash
cd divisibility-checker
java -jar target/divisibility-checker-1.0-SNAPSHOT.jar
```
Running the Array Handler

```bash
cd array-handler
java -jar target/array-handler-1.0-SNAPSHOT.jar
```

Running the Person Management Service

```bash
cd person-management-service
java -jar target/person-management-service-1.0-SNAPSHOT.jar
```

## Unit Testing

Each module contains unit tests developed with JUnit 5. Execute these tests by running the following command within the module's directory:

```bash
mvn test
```

## Contact 

Arao Diego Schujmann - ardisch@hotmail.com

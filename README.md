# StateStreet Bank Coding Exercises

## Overview
This repository contains a series of coding exercises for State Street Bank, structured as a multi-module Maven project. Each module within this project represents a different coding challenge, showcasing Java programming skills, problem-solving abilities, and familiarity with Java stack

## Modules

- **Exercise 1: Divisibility Checker (`divisibility-checker`)**: A Java application that prints numbers from 1 to 20, applying specific rules for numbers divisible by 3 and 5. It uses Java Streams for processing and JUnit 5 for unit testing.

[Add other modules and their descriptions as they are created]

## Prerequisites

- Java JDK 8 or later
- Maven 3.6.0 or later

## Building the Project

To build all modules in the project, navigate to the root directory and run:

```bash
mvn clean install
```
## Running Individual Modules

To execute a specific module, navigate to the module's directory and run the application using Maven. For example, to run the Divisibility Checker:

```bash
cd divisibility-checker
mvn exec:java -Dexec.mainClass="com.statestreet.exercises.DivisibilityChecker" 
```

## Unit Testing

Each module contains unit tests developed with JUnit 5. Execute these tests by running the following command within the module's directory:

```bash
mvn test
```

## Contact 

Arao Diego Schujmann - ardisch@hotmail.com

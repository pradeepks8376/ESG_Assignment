# StringCalculator Project

## Overview
The `StringCalculator` project is a standlone program to perform arithmetic operations on numbers provided as strings. It primarily focuses on summing numbers separated by delimiters in a string format. The project showcases basic principles of test-driven development (TDD) and unit testing in Java.

## Features
- Add numbers provided as strings with various delimiters.
- Handle unknown amount of numbers.
- Handle new lines between numbers.
- Support custom delimiters.
- Ignore non-numeric values and handle edge cases such as empty strings.

## Prerequisites
- **Java**: Ensure that you have JDK 8 or higher installed.
- **Maven**: The project uses Maven for dependency management and build processes.

## Installation
1. Clone the repository to your local machine:
    ```bash
    git clone https://github.com/pradeepks8376/ESG_Assignment.git
    cd ESG_Assignment/StringCalculator
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

# CSV to REST API Java Application Project

## Project Setup

1. Clone the repository
2. Navigate to the project directory
3. Run `mvn clean install` to build the project

## Running the Application

- Run the application using your IDE or `mvn spring-boot:run`
- Run the Console application ConsoleInput.java to load CSV file to h2 database


## REST API Endpoints

- POST `/api/customers/save` to save csv content 
- GET `/api/customers/{customerRef}` to retrieve customercontent  by using customer reference

## TDD Approach

- Tests are located in the `src/test` directory
- Tests cover CSV reading, API communication

## Dependencies

- Spring Boot
- apache-commons
- lombok
- H2 Database

# CSV to REST API Java Application

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

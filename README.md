Simple API CRUD Educator Management
This project provides a simple API for managing educator information, including standard Create, Read, Update, and Delete (CRUD) operations. It consists of a backend developed with Spring Boot and a frontend built with React.
![image](https://github.com/user-attachments/assets/e5103c58-57bb-4cd7-9d6b-51cc6b865e73)

![image](https://github.com/user-attachments/assets/0709d4b0-aa78-4185-81f5-4c0c921ea726)

![image](https://github.com/user-attachments/assets/bfaec3df-8cb7-4372-ba6e-81f5f7bc5a6e)

![image](https://github.com/user-attachments/assets/030b3231-5b78-489d-bc69-c4796b3801da)


Project Structure
The project is divided into two main parts:

backend: Contains the Spring Boot application, responsible for handling API requests, business logic, and data persistence.
frontend: Contains the React application, providing the user interface for interacting with the backend API.
Technologies Used
Backend (Java Spring Boot)
Java: The primary programming language.
Spring Boot: Framework for building robust, stand-alone, production-grade Spring-based applications.
Maven: Dependency management and build automation tool.
Database: H2.
Frontend (React)
React: A JavaScript library for building user interfaces.
JavaScript : The primary programming language.
HTML/CSS: For structuring and styling the web application.
npm / Yarn: Package managers for JavaScript dependencies.
Dependencies
Backend Dependencies (Maven - pom.xml)
Common dependencies for a Spring Boot CRUD application often include:

spring-boot-starter-web: For building RESTful APIs using Spring MVC.
spring-boot-starter-data-jpa: For integrating with relational databases using JPA and Hibernate.
spring-boot-starter-test: For writing unit and integration tests.
Database Driver: e.g., h2 (for an in-memory database during development) or mysql-connector-java, postgresql for production database.
Example snippet you might find in pom.xml:

XML

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
Frontend Dependencies (npm/Yarn - package.json)
Common dependencies for a React application interacting with an API include:

react: The core React library.
react-dom: Enables React components to be rendered in the DOM.
react-scripts: (If created with Create React App) Scripts for development, building, and testing.
react-router-dom: For client-side routing within the React application.
axios or fetch API: For making HTTP requests to the backend.
Example snippet you might find in package.json:

JSON

{
  "dependencies": {
    "react": "^18.2.0",
    "react-dom": "^18.2.0",
    "react-scripts": "5.0.1",
    "react-router-dom": "^6.22.3",
    "axios": "^1.6.8",
    "web-vitals": "^2.1.4"
  },
  "devDependencies": {
    "@testing-library/jest-dom": "^5.17.0",
    "@testing-library/react": "^13.4.0",
    "@testing-library/user-event": "^13.5.0"
  },
  "browserslist": {
    "production": [
      ">0.2%",
      "not dead",
      "not op_mini all"
    ],
    "development": [
      "last 1 chrome version",
      "last 1 firefox version",
      "last 1 safari version"
    ]
  }
}
Setup and Running the Application
Backend Setup
Navigate to the backend directory: cd backend
Build the project using Maven: mvn clean install
Run the Spring Boot application: mvn spring-boot:run The backend will typically run on http://localhost:8080.
Frontend Setup
Navigate to the frontend directory: cd frontend
Install dependencies: npm install (or yarn install)
Start the React development server: npm start (or yarn start) The frontend will typically open in your browser at http://localhost:3000.
Usage
Once both the backend and frontend servers are running, you can access the application through your web browser at http://localhost:3000. The frontend will interact with the backend API to perform CRUD operations on educator data.

For further details on specific endpoints or data models, please refer to the source code within the backend directory.

linkin: https://www.linkedin.com/in/celenkosini-s-nyawo-83368278/


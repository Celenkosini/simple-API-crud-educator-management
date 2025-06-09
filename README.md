

# 🎓 Educator Management CRUD App

A full-stack web application that enables users to perform Create, Read, Update, and Delete (CRUD) operations on educator records. Built with **Spring Boot** for the backend and **React** for the frontend, this project demonstrates seamless integration between a RESTful API and a dynamic user interface.

---

## 🚀 Features

* **Educator Management**: Add, view, update, and delete educator information.
* **RESTful API**: Backend API built with Spring Boot following REST principles.
* **Responsive UI**: Frontend developed with React, ensuring a user-friendly experience across devices.
* **Data Persistence**: Utilizes MySQL for storing educator data.
* **Error Handling**: Implements comprehensive error handling for robust application performance.

---

## 🛠️ Technologies Used

### Backend

* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA**
* **MySQL**
* **Maven**

### Frontend

* **React 18**
* **Axios**
* **Bootstrap 5**

---

## 📂 Project Structure

```
educator-management/
├── backend/
│   ├── src/
│   ├── pom.xml
│   └── ...
└── frontend/
    ├── public/
    ├── src/
    ├── package.json
    └── ...
```

---

## 🖥️ Screenshots

![image](https://github.com/user-attachments/assets/ea83c697-2e3c-4895-aa3e-ec2e914b8f16)

![image](https://github.com/user-attachments/assets/502f8c38-225e-47e3-9520-86e9a47be50a)

![image](https://github.com/user-attachments/assets/80a1a8f0-b4af-4fe9-8b9f-49b36b664fad)

---

## 🧪 Getting Started

### Prerequisites

* **Java 17**
* **Node.js 16+**
* **MySQL**

### Backend Setup

1. **Clone the repository**:

   ```bash
   git clone https://github.com/Celenkosini/simple-API-crud-educator-management.git
   cd simple-API-crud-educator-management/backend
   ```

2. **Configure the database**:

   * Create a MySQL database named `educator_db`.
   * Update the `application.properties` file with your MySQL credentials.

3. **Build and run the backend**:

   ```bash
   mvn spring-boot:run
   ```

   The backend will start on `http://localhost:8080`.

### Frontend Setup

1. **Navigate to the frontend directory**:

   ```bash
   cd ../frontend
   ```

2. **Install dependencies**:

   ```bash
   npm install
   ```

3. **Start the frontend**:

   ```bash
   npm start
   ```

   The frontend will run on `http://localhost:3000`.

---

## 📡 API Endpoints

| Method | Endpoint            | Description             |
| ------ | ------------------- | ----------------------- |
| GET    | /api/educators      | Retrieve all educators  |
| GET    | /api/educators/{id} | Retrieve educator by ID |
| POST   | /api/educators      | Add a new educator      |
| PUT    | /api/educators/{id} | Update educator details |
| DELETE | /api/educators/{id} | Delete an educator      |

---

## 🚀 Deployment

Link:https://educator-management-d1379d58f934.herokuapp.com

---

## 🤝 Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements.

---


## 📬 Contact

**Celenkosini Nyawo**

* **Email**: csmadlopha@gmail.com
* **LinkedIn**: https://www.linkedin.com/in/celenkosini-s-nyawo-83368278/
* **GitHub**: [Celenkosini](https://github.com/Celenkosini)

---



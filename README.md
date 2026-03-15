# 📚 Library Management System - Backend

The backend of the Library Management System built with Spring Boot and MySQL. It exposes REST APIs consumed by the frontend and is deployed on Render.

---

## 🚀 Features

- 📖 REST APIs for managing books
- 👤 REST APIs for managing members
- 🔄 Issue and return book endpoints
- 🔍 Search functionality by title, author, or category
- 📊 Borrowing history and records
- 🔐 Admin authentication

---

## 🛠️ Tech Stack

| Technology   | Usage                |
|--------------|----------------------|
| Java         | Programming Language |
| Spring Boot  | Backend Framework    |
| MySQL        | Database             |
| Maven        | Build Tool           |

---

## 🌐 Live Deployment

The backend is deployed on **Render**.
> 🔗 API Base URL: `https://librarymanagementbackend-d5pk.onrender.com`

---

## ⚙️ Prerequisites

Make sure you have the following installed to run locally:

- [Java JDK 17+](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [MySQL](https://www.mysql.com/)

---

## 🖥️ How to Run Locally

### 1. Clone the repository
```bash
git clone https://github.com/Darshan-11-create/libraryManagementBackend.git
cd libraryManagementBackend
```

### 2. Configure the Database
- Create a MySQL database:
  ```sql
  CREATE DATABASE library_db;
  ```
- Create a file `demo/src/main/resources/application.properties` and add:
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/library_db
  spring.datasource.username=your_mysql_username
  spring.datasource.password=your_mysql_password
  spring.jpa.hibernate.ddl-auto=update
  ```

> ⚠️ **Security Note:** Never commit your real database credentials to GitHub. Add `application.properties` to your `.gitignore` to keep them safe.

### 3. Run the Backend
```bash
cd demo
mvn spring-boot:run
```
The server will start at `http://localhost:8080`

---

## 📁 Project Structure

```
libraryManagementBackend/
├── demo/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/       # Controllers, Services, Repositories
│   │   │   └── resources/  # application.properties
│   └── pom.xml
└── README.md
```

---

## 🔗 Related

- Frontend Repo: [LibraryManagement](https://github.com/Darshan-11-create/LibraryManagement)

---

## 📬 Contact

Made by **Darshan** — feel free to reach out!

- GitHub: [@Darshan-11-create](https://github.com/Darshan-11-create)

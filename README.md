# 🍍 Fruit API — Spring Boot + MySQL

A simple RESTful API to manage fruits using Spring Boot, JPA, MySQL and validation via DTOs.

---

## 📦 Features

- Full CRUD operations (`POST`, `GET`, `PUT`, `DELETE`)  
- Validated input with DTOs (`FruitRequest`)  
- Persistence via MySQL database  
- Auto table generation with JPA/Hibernate  
- Clean architecture with model, service, repository, controller layers

---

## 🚀 Technologies Used

- Java
- Spring Boot 3  
- Spring Data JPA  
- MySQL  
- Jakarta Bean Validation  
- Maven

---

## ⚙️ Getting Started

### 1. Clone the repo: https://github.com/ToniR90/4.2-API-REST-SpringBoot-Nivell2.git


### 2. Configure your database

Create the database manually in MySQL: 

```bash
CREATE DATABASE fruit_db;
```


### 3. Set up application properties

Copy the sample config file:

```bash
cp src/main/resources/application-example.properties src/main/resources/application.properties
```

Then fill in your real MySQL username and password in the new file:

```
spring.datasource.username=your_username
spring.datasource.password=your_password
```


🛑 Do not commit your real application.properties!
It's excluded via .gitignore to avoid leaking credentials.

🛠️ Running the app
mvn spring-boot:run

---

The app will be available at:

👉 http://localhost:8080

---

🛡️ Validation
The FruitRequest DTO includes:
- @NotBlank for name
- @NotNull and @Min(1) for quantity
Errors will return HTTP 400 with helpful messages.

---

📝 Notes
- The real application.properties is ignored by Git (.gitignore)
- Please use application-example.properties to replicate configuration
- Hibernate auto-generates the fruits table upon app startup

---

## 🌐 Usefull resources

### _*Beginner's CRUD guide Spring + MySQL*_

https://dev.to/abhi9720/a-beginners-guide-to-crud-operations-of-rest-api-in-spring-boot-mysql-5hcl


https://www.youtube.com/watch?v=1BYxZCFjfyU




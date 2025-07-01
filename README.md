# 🍍 Fruit API — Spring Boot + Mongo

A simple RESTful API to manage fruits using Spring Boot, JPA, Mongo and validation via DTOs.

---

## 📦 Features

- Full CRUD operations (`POST`, `GET`, `PUT`, `DELETE`)  
- Validated input with DTOs (`FruitRequest`)  
- Persistence via Mongo database  
- Auto table generation with JPA/Hibernate  
- Clean architecture with model, service, repository, controller layers

---

## 🚀 Technologies Used

- Java
- Spring Boot 3  
- Spring Data JPA  
- Mongo  
- Jakarta Bean Validation  
- Maven

---

## ⚙️ Getting Started

### 1. Clone the repo: https://github.com/ToniR90/4.2-API-REST-SpringBoot-Nivell3.git


### 2. Run MongoDB locally

Ensure MongoDB is running on your machine at `localhost:27017`

- If installed locally:


```bash
mongod
```


### 🛠️ 4. Running the app
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
- _MongoDB will automatically create the fruit_db database and fruits collection on first insertion_
- Mongo uses ObjectIds (_id) as document identifiers by default


---

## 🌐 Usefull resources

### _*Beginner's CRUD guide Spring + Mongo*_

https://www.geeksforgeeks.org/spring-boot-crud-operations-using-mongodb/


https://itacademy.barcelonactiva.cat/mod/assign/view.php?id=13411




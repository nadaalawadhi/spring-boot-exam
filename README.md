# spring-boot-exam

### Product Management API

A Spring Boot REST API for managing a product inventory, allowing for full CRUD (Create, Read, Update, Delete) operations on product records.

### How to Run

To start the application, navigate to the project root in your terminal and run:
```bash
./mvnw spring-boot:run
````
### API Endpoints

| Method | URL | Description | Status Codes |
| :--- | :--- | :--- | :--- |
| GET | `/api/products` | Retrieve all products | 200 OK |
| GET | `/api/products/{id}` | Retrieve a single product by ID | 200 OK, 404 Not Found |
| POST | `/api/products` | Create a new product | 201 Created |
| PUT | `/api/products/{id}` | Update an existing product | 200 OK, 404 Not Found |
| DELETE | `/api/products/{id}` | Remove product from inventory | 204 No Content, 404 Not Found |

### curl Examples
open a new Command Prompt and run the following
#### Create a Product:
```bash
curl -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d "{\"name\":\"Uno\",\"category\":\"Toy\",\"price\":9.99,\"quantity\":50}" -v
  

curl -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d "{\"name\":\"Domino\",\"category\":\"Toy\",\"price\":5.45,\"quantity\":30}" -v
  ```

#### Get All Products:
```bash
curl -X GET http://Localhost:8080/api/products -v
  ```

#### Get Product by ID:
```bash
curl -X GET http://Localhost:8080/api/products/1 -v

curl -X GET http://Localhost:8080/api/products/5 -v
```

#### Update a Product:
```bash
curl -X PUT http://localhost:8080/api/products/1 -H "Content-Type: application/json" -d "{\"name\":\"Uno\",\"category\":\"Toy\",\"price\":9.95,\"quantity\":50}" -v
```

#### Delete a Product:
```bash
curl -X DELETE http://Localhost:8080/api/products/1 -v
```

#### Search a Product by Keyword:
```bash
curl -X GET "http://localhost:8080/api/products/search?keyword=Uno" -v
```

#### Find Products by Category:
```bash
curl -X GET "http://localhost:8080/api/products/category/Toy" -v
```


### Sample Responses
#### Create a Product:
```bash
{"name":"Uno","category":"Toy","price":9.99,"quantity":50,"id":4}
```

#### Get All Products:
```bash
[{"name":"Uno","category":"Toy","price":9.99,"quantity":50,"id":1},
{"name":"Domino","category":"Toy","price":5.45,"quantity":30,"id":2}]
```

#### Get Product by ID:
```bash
{"name":"Domino","category":"Toy","price":5.45,"quantity":30,"id":2}
```
#### Update a Product:
```bash
{"name":"Uno","category":"Toy","price":9.95,"quantity":50,"id":1}
```
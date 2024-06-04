## API Documentation

### User Registration

- **Endpoint:** `/register`
- **Method:** POST
- **Description:** Register a new user.
- **Request Body:**
  ```json
  {
    "username": "user123",
    "password": "password123"
  }
  ```
- **Response:** 
  - 200 OK: User registered successfully. Returns user information.
  - 400 Bad Request: Malformed request body or username already exists. Returns an error message.

### User Login

- **Endpoint:** `/login`
- **Method:** POST
- **Description:** Login a user.
- **Request Body:**
  ```json
  {
    "username": "user123",
    "password": "password123"
  }
  ```
- **Response:** 
  - 200 OK: Login successful. Returns a success message and sets a cookie with the JWT token.
  - 401 Unauthorized: Invalid credentials. Returns an error message.
  - 400 Bad Request: Malformed request body. Returns an error message.

### Add Transaction

- **Endpoint:** `/transactions`
- **Method:** POST
- **Description:** Add a new transaction for the authenticated user.
- **Authorization:** Required (Bearer token obtained after successful login)
- **Request Body:**
  ```json
  {
    "userId": "user123",
    "category": "Grocery",
    "amount": 50.00,
    "timestamp": "2024-05-28T12:00:00"
  }
  ```
- **Response:** 
  - 200 OK: Transaction added successfully.

### View Transactions

- **Endpoint:** `/transactions/{userId}`
- **Method:** GET
- **Description:** View all transactions for a specific user.
- **Authorization:** Required (Bearer token obtained after successful login)
- **Response:**
  - **200 OK:** List of transactions associated with the specified user.
    ```json
    [
      {
        "id": 1,
        "userId": "user123",
        "category": "Grocery",
        "amount": 50.00,
        "timestamp": "2024-05-28T12:00:00"
      },
      // More transactions...
    ]
    ```
 

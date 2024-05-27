# SpendiSmart - User Authentication and Expense Management API

SpendiSmart is a Spring Boot backend application that provides user authentication and expense management APIs. It allows users to register, log in, and manage their expenses efficiently.

## Description

SpendiSmart simplifies the process of managing expenses by providing a secure authentication system for users to register and log in. Once authenticated, users can access the expense management APIs to perform various operations, such as adding new expenses, viewing existing expenses, and categorizing expenses.

## Features

- **User Authentication:**
  - Register new users with unique usernames.
  - Authenticate users securely using password hashing.
  - Log in and log out functionality with session management.

- **Expense Management:**
  - Add new expenses with details such as description, amount, and timestamp.
  - View existing expenses.
  - Categorize expenses for better organization and analysis.

## API Documentation

### User Registration

- **Endpoint:** `/register`
- **Method:** POST
- **Description:** Register a new user.
- **Request Body:**
  ```json
  {
    "username": "example_user",
    "password": "password123"
  }
  ```
- **Response:** 
  - 200 OK: User registered successfully.
  - 400 Bad Request: If the username already exists or validation fails.
 
### User Login

- **Endpoint:** `/login`
- **Method:** POST
- **Description:** Log in an existing user.
- **Request Body:**
  ```json
  {
    "username": "example_user",
    "password": "password123"
  }
  ```
- **Response:** 
  - 200 OK: Login successful. Returns a success message or user information.
  - 401 Unauthorized: Invalid credentials. Returns an error message.
  - 400 Bad Request: Malformed request body. Returns an error message.

### Add Expense

- **Endpoint:** `/expenses`
- **Method:** POST
- **Description:** Add a new expense for the authenticated user.
- **Authorization:** Required (Bearer token obtained after successful login)
- **Request Body:**
  ```json
  {
    "userId": "user123",
    "description": "Grocery shopping",
    "amount": 50.00,
    "timestamp": "2024-05-28T12:00:00"
  }
- **Response:** 
  - 200 OK: Expense added successfully.

### View Expenses

- **Endpoint:** `/expenses`
- **Method:** GET
- **Description:** View all expenses for the authenticated user.
- **Authorization:** Required (Bearer token obtained after successful login)
- **Response:**
  - **200 OK:** List of expenses associated with the authenticated user.
    ```json
    [
      {
        "id": 1,
        "userId": "user123",
        "description": "Grocery shopping",
        "amount": 50.00,
        "timestamp": "2024-05-28T12:00:00"
      },
      {
        "id": 2,
        "userId": "user123",
        "description": "Dinner with friends",
        "amount": 75.00,
        "timestamp": "2024-05-27T19:30:00"
      }
    ]
    ```
  - **401 Unauthorized:** Authentication failed or token expired. Returns an error message.

  - **403 Forbidden:** If the user does not have permission to access expenses. Returns an error message.
  - **404 Not Found:** If no expenses are found. Returns an empty list.


 

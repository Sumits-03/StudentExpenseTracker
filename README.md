# Student Expense Tracker

A console-based expense management application developed using Java, JDBC, and MySQL.

## Features

- Add expenses
- View all expenses
- Update expenses
- Delete expenses
- Search expenses by category
- Calculate total spending
- Persistent storage using MySQL

## Technologies Used

- Java
- Object-Oriented Programming
- JDBC
- MySQL
- Git & GitHub
- VS Code

## Project Structure

StudentExpenseTracker/
├── src/
│   ├── Main.java
│   ├── Expense.java
│   ├── ExpenseDAO.java
│   └── DBConnection.java
│
├── lib/
│   └── MySQL Connector/J
│
├── .gitignore
└── README.md

## Database

Database name:

student_expense_tracker

Table:

expenses

## How It Works

The application takes expense details through the Java console and uses JDBC to communicate with MySQL.

User
↓
Java Console Application
↓
ExpenseDAO
↓
JDBC
↓
MySQL

## Future Improvements

- Monthly expense reports
- Budget tracking
- Expense visualization
- GUI/Web interface
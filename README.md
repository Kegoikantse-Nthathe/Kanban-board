# Kanban-board
Kanban is a Java-based task management system that simulates a Kanban board. It allows users to register, log in, and manage tasks across To Do, Doing, and Done stages. Features include task creation, validation, reporting, search, deletion, and total hour tracking using OOP, arrays, and unit testing.
<br>
# 📌 Overview
EasyKanban is a simple task management system built using Java that simulates a Kanban board workflow. The system allows users to register, log in, and manage tasks across different stages: To Do, Doing, and Done.<br>

This project was developed as part of a Portfolio of Evidence (POE) to demonstrate understanding of core programming concepts such as object-oriented programming, arrays, loops, string manipulation, and unit testing.

# 🚀 Features

## 🔐 User Authentication
  - User registration with:<br>
    - Username validation (must include _ and be ≤ 5 characters)<br>
    - Secure password validation (minimum 8 characters, uppercase, number, special character)<br>
  - Login system that verifies credentials<br>
  - Personalized welcome message after successful login<br>
  
## 📋 Task Management
- Add tasks after successful login<br>
- Each task includes:<br>
  - Task name<br>
  - Auto-generated task number<br>
  - Task description (max 50 characters)<br>
  - Developer details<br>
  - Task duration (hours)<br>
  - Auto-generated Task ID<br>
  - Task status (To Do / Doing / Done)<br>
  
## 🧠 Smart Task Handling
- Input validation for task descriptions<br>
- Automatic Task ID generation<br>
- Menu-driven system for user interaction<br>
- Continuous loop until user chooses to exit<br>
- Total task hours calculation<br>

## 📊 Task Reporting & Management
- Store task data using arrays<br>
- Display:<br>
  - Tasks marked as Done<br>
  - Task with the longest duration<br>
- Search functionality:<br>
  - Search by task name<br>
  - Search by developer<br>
- Delete tasks by name<br>
- Display full task report<br>

## 🧱 Technologies Used
- Java (OOP)<br>
- Arrays<br>
- Loops<br>
- String manipulation<br>
- Conditional statements<br>
- Unit testing (JUnit)<br>
- Git & GitHub<br>

## 🧪 Testing
- The system includes unit tests to validate:<br><br>
- Username formatting<br>
- Password complexity rules<br>
- Login success and failure cases<br>
- Task description validation<br>
- Task ID generation<br>
- Array population and task operations<br>
- Total duration calculations<br>

## 📚 Key Concepts Demonstrated
- Object-Oriented Programming (OOP)<br>
- Encapsulation (classes and methods)<br>
- Input validation<br>
- Looping and iteration<br>
- Arrays and data storage<br>
- Modular programming<br>
- Unit testing and test-driven development<br>

## 🎯 Learning Outcome
This project demonstrates how a simple real-world workflow (Kanban task tracking) can be implemented using core programming principles. It reinforces building structured, testable, and maintainable Java applications.

## 👨‍💻 Author
Developed as part of a PRLD5121 Portfolio of Evidence project.

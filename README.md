# Task Manager

A command-line Task Manager application built with Java and PostgreSQL that helps you track your day-to-day tasks.

---

## Features

- Add a new task
- View a specific task by ID
- View all tasks
- Update task name, description, status, or all fields
- Delete a task
- Filter tasks by status (TODO / IN_PROGRESS / DONE)

---

## Tech Stack

- Java
- JDBC
- PostgreSQL

---

## Database Setup

Make sure PostgreSQL is installed and running. Then create the database and table:

```sql
CREATE DATABASE task_manager;

\c task_manager

CREATE TABLE task (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    taskname VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'TODO'
);
```

---

## How to Run

1. Install Java (JDK 17 or above) and any Java IDE (IntelliJ IDEA / Eclipse)
2. Install and set up PostgreSQL
3. Create the database and table using the SQL above
4. Clone this repository
5. Open the project in your IDE
6. The default database name is `task_manager`, username is `postgres`, and password is `postgres`
   - If yours are different, update the connection details in `TaskRepositoryImpl.java`
7. Run `Main.java`

---

## Project Structure

```
├── Main.java                  # Entry point, handles user input
├── Task.java                  # Task model with validation
├── Status.java                # Enum for task status (TODO, IN_PROGRESS, DONE)
├── TaskRepository.java        # Repository interface
├── TaskRepositoryImpl.java    # JDBC implementation, handles all DB operations
├── TaskService.java           # Service layer, business logic
```

---

## Author

**Arun** — Final year B.Tech CSE (AI & ML) student passionate about Java backend development.

[GitHub](https://github.com/arunpalanivel) • [LinkedIn](https://linkedin.com/in/arunpalanivel23)
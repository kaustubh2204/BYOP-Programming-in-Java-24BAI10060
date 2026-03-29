# BYOP-Programming-in-Java-24BAI10060
## Student Track Manager
It is a Java-based desktop application designed to help students manage their academic workload. It solves the common problem of "deadline stress" by providing a centralized, persistent interface to track assignments, subjects, and due dates.

### Features
**Task Management:** Add, view, and track assignments with specific due dates.

**Status Tracking:** Toggle tasks between "Pending" and "Done" to visualize progress.

**Data Persistence:** Automatically saves your task list to a local file (tasks.dat), ensuring your data is safe even after closing the app.

**User-Friendly GUI:** A clean, organized interface built with Java Swing.

**Error Handling:** Robust validation for date formats to prevent application crashes.

### Tech Stack & Concepts
This project demonstrates core Java competencies required for the course:

**Object-Oriented Programming (OOP):** Encapsulation (Task objects) and Abstraction.

**Collections Framework:** Used java.util.List and ArrayList for dynamic data management.

**File I/O:** Implemented ObjectOutputStream and ObjectInputStream for serialization.

**GUI Development:** Built using javax.swing and java.awt layout managers.

**Exception Handling:** Managed parsing errors and input validation using try-catch blocks.

### Project Structure
**Task.java:** The model class representing a single assignment.

**TaskMang.java:** The main controller and GUI class.

**tasks.dat:** The binary data file where the tasks are stored (generated after first save).

### How to Run
Ensure JDK is installed: You need Java 8 or higher.

#### Download the files:
Clone this repository or download *Task.java* and *TaskMang.java.*

#### Compile the project:
Open your terminal/command prompt and run:

bash
```
javac Task.java TaskMang.java
```
#### Launch the application:

bash
```
java TaskMang
```
### Usage Instructions
Enter the Assignment *Title** and *Subject*.

Enter the *Due Date* in *YYYY-MM-DD format* (e.g., 2026-03-31).

Click *Add Task* to populate the table.

To *mark a task* as finished, select the row in the table and click Complete Task.

Click *Save Data* before exiting to ensure your changes are kept.

**Author:** Kaustubh Upadhyay

**Registration Number:** 24BAI10060

**Slot:** A21+A22

**Course:** Programming in Java

**Project Date:** 29 March 2026

# Employee Management System

A small Java 17 + Maven console application for a basic employee directory.

## Features
- Add an employee
- View all employees
- Search by employee ID
- Delete an employee
- Reject duplicate employee IDs

Data is stored in memory, so it resets when the application exits. This keeps the demo simple.

## Requirements
- JDK 17
- Maven 3.8+

## Run locally
```bash
mvn clean test package
java -cp target/classes com.example.Main
```

## GitHub + Jenkins pipeline
1. Create a GitHub repository named `employee-management`.
2. Upload/push all files in this project to the repository.
3. In Jenkins, install/enable the Git and Pipeline plugins.
4. Configure JDK tool name as `JDK17` and Maven tool name as `Maven3` under **Manage Jenkins → Tools**. Use installed JDK 17 and Maven 3.
5. Create **New Item → Pipeline**.
6. Under Pipeline, select **Pipeline script from SCM**, choose **Git**, enter the GitHub repository URL, and set the branch to `*/main`.
7. Set Script Path to `Jenkinsfile`, save, then select **Build Now**.
8. Open the build and inspect **Console Output**. Jenkins should show Checkout, Compile, Test and Build Verification as successful.

For a private GitHub repository, add a GitHub credential in Jenkins and select it in the SCM configuration.

## What the pipeline verifies
- Checkout: retrieves the latest committed source from GitHub.
- Compile: checks that Java source compiles.
- Test: runs the JUnit tests.
- Package: creates the application build under `target/`.
- Post-build: publishes test results and archives the JAR.

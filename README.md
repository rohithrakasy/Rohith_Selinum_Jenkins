# Selenium Java Test Automation Framework

## Overview

This project is a Selenium automation framework developed using Java and TestNG. It is designed to automate the OrangeHRM demo application by following the Page Object Model (POM) design pattern. The framework is built to be easy to maintain, reusable, and scalable.

Application Under Test:
https://opensource-demo.orangehrmlive.com/

---

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- Extent Reports
- TestNG Listeners
- Git
- Jenkins

---

## Framework Features

- Page Object Model (POM)
- TestNG test execution
- Screenshot capture for failed tests
- Extent HTML reports
- TestNG Listeners
- Reusable utility classes
- Maven project structure
- Git version control

---

## Project Structure

```
Selenium_Automation
│
├── src/main/java
│   ├── base
│   ├── pages
│   ├── listeners
│   ├── reports
│   └── utils
│
├── src/test/java
│   └── tests
│
├── screenshots
├── extent-report
├── test-output
├── pom.xml
└── testng.xml
```

---

## Current Test Scenario

- Launch OrangeHRM application
- Login using valid credentials
- Verify Dashboard page
- Capture screenshot if the test fails
- Generate Extent Report after execution

---

## How to Run

### Using Eclipse

Right-click on **testng.xml**

Run As → TestNG Suite

### Using Maven

```bash
mvn clean test
```

---

## Reports

After execution, reports are available in:

```
extent-report/
```

TestNG reports are available in:

```
test-output/
```

Failed screenshots are stored in:

```
screenshots/
```

---

## Version History

| Version | Description |
|----------|-------------|
| v1.0 | Initial framework setup |
| v2.0 | Added Screenshot Utility, TestNG Listeners and Extent Reports |

---

## Planned Enhancements

- Data Driven Testing
- Cross Browser Execution
- Parallel Execution
- Jenkins Pipeline
- GitHub Actions
- Docker Selenium Grid
- Log4j Logging
- Retry Analyzer

---

## Author

Rohith Kumar Reddy Rakasy

Software Test Engineer

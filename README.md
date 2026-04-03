# Playwright Test Automation Framework

This is a Java-based test automation framework using Playwright, Cucumber, Apache POI, and Extent Reports.

## Prerequisites

- Java 8 or higher
- Maven 3.x

## Setup

1. Clone or download the project.
2. Navigate to the project directory.
3. Run `mvn clean compile` to download dependencies and compile the project.
4. Install Playwright browsers: Run `mvn exec:java -Dexec.mainClass="com.microsoft.playwright.CLI" -Dexec.args="install"` or Playwright will install them on first run.

## Running Tests

- Run all tests: `mvn test`
- Run specific test: `mvn test -Dtest=TestRunner`

## Project Structure

- `src/main/java/com/example/pages/` - Page Object classes
- `src/test/java/stepdefinitions/` - Cucumber step definitions
- `src/test/java/runners/` - Test runners
- `src/test/java/utils/` - Utility classes like Extent Report manager
- `src/test/resources/features/` - Cucumber feature files
- `pom.xml` - Maven configuration

## Reports

- Extent Reports: `target/ExtentReport.html`
- Cucumber Reports: `target/cucumber-reports.html`

## Included Test

- Launches Chrome browser and navigates to BrowserStack website, verifying the page title.
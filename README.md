# GameFlix Backend

## Overview

GameFlix is a cloud-based video game streaming platform for Penn State IST 412.
This repository contains the Spring Boot backend for the application which includes:

-User Registration

-User authentication

-Spring Security config

-MySQL database

-Docker support

-GitHub Actions CI workflow

---

## Running the App
### Local development
Run the Spring Boot app from IntelliJ or with Maven

The app uses a local MYSQL database configured in:

src/main/resources/application.properties

### Docker
Build and start the app with:

---bash

docker compose up --build

---
The app will be available at:

http://loclahost:8080

## Continuous Integration

This project uses GitHub Actions for CI

The workflow will automatically:

-Check out the repository

-Set up Java 21

-Start a MySQL service

-Build the project with Maven

-Build a Docker image

The workflow definition is located:

.github/workflow/ci.yml

---

## Author

Samuel Lee

Penn State University

IST 412 - Software Engineering
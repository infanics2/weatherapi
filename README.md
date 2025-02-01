# Weather Service API

## Overview

The Weather Service API is a containerized Spring Boot application that provides authentication and real-time weather reports. The application is built with Java, Spring Boot, and Docker, allowing easy deployment and scalability.

## Features

User Authentication (Register & Login)

- Weather Reports based on location queries
- RESTful API with JSON responses
- Containerized with Docker for easy deployment

## Prerequisites

Ensure you have the following installed:

- Docker
- Docker Compose
- Java 17+ (if running locally)

## Getting Started

Clone the Repository

git clone git@github.com:infanics2/weatherapi.git

cd weather-service-api

## Build and Run the Application with Docker

Use Docker Compose to build and run the application:

docker-compose up --build

This will build the application and start the necessary containers.

API Endpoints

## Authentication Endpoints

Base URL: http://localhost:8080/api/v1/auth

# Register a New User

Endpoint: POST /register

Request Body:

{
"username": "testuser",
"password": "securepassword"
}

Response:

{
"token": "your-jwt-token"
}

# Authenticate User

Endpoint: POST /authenticate

Request Body:

{
"username": "testuser",
"password": "securepassword"
}

Response:

{
"token": "your-jwt-token"
}

Weather Report Endpoints

Base URL: http://localhost:8080/api/v1

Get Weather Report

Endpoint: GET /weather-report

Request Body:

"Tashkent"

Response:

{
    "name": "Tashkent",
    "country": "Uzbekistan",
    "latitude": 41.3167,
    "longitude": 69.25,
    "tempC": 4.3,
    "tempColor": "#D1F2D3",
    "windKph": 6.1,
    "windColor": "#E0F7FA",
    "cloud": 0,
    "cloudColor": "#FFF9C4"
}

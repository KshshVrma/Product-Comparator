# Product Comparison Application

This is a Spring Boot-based web application that scrapes product details from Amazon and Flipkart and compares them. It also integrates with a Gemini service to generate additional content based on the comparison.

## Features

- Scrape product details (name, price, and link) from Amazon and Flipkart.
- Compare products from both platforms.
- Generate additional content using the Gemini service.
- RESTful API endpoints for product comparison and scraping.

## Technologies Used

- **Java 17**
- **Spring Boot**
- **Maven**
- **Selenium** (for web scraping)
- **Jsoup** (for HTML parsing)
- **Thymeleaf** (optional for UI rendering)

## Prerequisites

- Java 17 or higher
- Maven
- Chrome browser (for Selenium)
- ChromeDriver (compatible with your Chrome version)

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd products
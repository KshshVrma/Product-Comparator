# Product Comparison

This project is a Spring Boot application that compares product prices from Amazon and Flipkart. It scrapes data from these websites and provides a simple interface to view the results.

## Features

*   Compare product prices from Amazon and Flipkart.
*   Web scraping using Jsoup and Selenium.
*   RESTful API to get product information.

## Technologies Used

*   Java 17
*   Spring Boot 3.5.3
*   Maven
*   Jsoup 1.17.2
*   Selenium 4.20.0
*   Thymeleaf
*   Lombok

## Getting Started

### Prerequisites

*   JDK 17 or later
*   Maven 3.2+
*   Google Chrome

### Installation

1.  Clone the repository:
    ```sh
    git clone https://github.com/your-username/product-comparison.git
    ```
2.  Navigate to the project directory:
    ```sh
    cd product-comparison
    ```
3.  Install the dependencies:
    ```sh
    mvn install
    ```

## Usage

1.  Run the application:
    ```sh
    mvn spring-boot:run
    ```
2.  Open your browser and navigate to `http://localhost:8080`.

## API Endpoints

*   `GET /`: Displays the main page.
*   `GET /search`: Searches for products on Amazon and Flipkart.
    *   Query parameter: `product` (e.g., `/search?product=laptop`)

## Contributing

Contributions are welcome! Please feel free to submit a pull request.

## License

This project is licensed under the MIT License.

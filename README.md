# ATOS OPTICA CUSTOMER MANAGEMENT


[![Build Status](https://travis-ci.org/pravreddy/atos_optica_customer_managment.svg)](https://travis-ci.org/pravreddy/atos_optica_customer_managment)

[![codecov](https://codecov.io/gh/pravreddy/atos_optica_customer_managment/branch/master/graph/badge.svg)](https://codecov.io/gh/pravreddy/atos_optica_customer_managment)


ATOS  OPTICA CUSTOMER MANAGEMENT APP is a simple HTTP based RESTful API that provides 3 operations for managing customers.

These Operations are:


* Operation 1: Add a Customer

    ```
        curl --header "Content-Type: application/json"  --request POST  \
        --data '{"Id": "A123456", "Firstname": "Bill", "Surname": "Gates"  }' \
        http://localhost:8180/api/customers
    ```

* Operation 2: Remove a Customer, given their ID

    ```
        curl -X DELETE http://localhost:8180/api/customers/A123456
    ```

* Operation 3: List all Customers

    ```
        curl  http://localhost:8180/api/customers/
    ```

Where a Customer has the following attributes:

* Id
* Firstname
* Surname


## To Build and Run

    * mvn clean install or mvn spring-boot:run or ./mvnw spring-boot:run
    * Goto target folder run - java -jar <filename>.jar

## Testing
    * Run CustomerApplicationTests from test folder
    * Run Postman collection script from project root folder
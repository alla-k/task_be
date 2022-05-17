This project represents oversimplified/toy order managment system (OOMS).

It is designed to allow customers to buy assets (ISINs), save orders and update customer balance.  

**Architecture:**
- System consists of 3 microservices ( spring-boot apps ) working together 
    - *Price-Handler* provides prices of any ISIN via REST-API  
    - *Customer-service*, *Order-Service* communicate via kafka
- *Customer-Service*
    - has a database to read customer id and name 
    - is responsible for generating purchase transactions ( *order.request* kafka topic )
- *Order-Service* 
    - is reponsible for ISIN "purchase".
    - is reponsible for onboarding new customers ( *onboard.customer* topic ) 
    - has a database to store customers accounts (balance) and orders 

![](schema.png?raw=true "Title")


**How to run:**
1. Build docker image for multi-postgres DB by running the following command from root directory:

```
docker build . -t multi-postgres
   ```

2. Run docker-compose, which will start databases and Kafka broker necessary to run microservices:
```
docker-compose up -d
   ```
3. Build and run Dockerfile in each of microservices folder to start corresponding microservice.  
   Suggested order of starting is price-service, order-service, customer-service

```
docker build . -t price-handler
docker run price-handler
   ```
4. After services are started, you can use kafkacat or any other tool of your choice to connect to Kafka broker on port 9092 and work with messages.
5. There are REST API endpoints available to create new customer and send orders (see customer-service). Examples of usage:
```
/addCustomer?name=testUser4&balance=20000
/addOrder?customerId=274c959c-fbab-4e0c-a8ab-14e7caadf62a&isin=DE000122&quantity=25
   ```
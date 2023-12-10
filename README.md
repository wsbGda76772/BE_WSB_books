# BE_WSB_books

## Framework used
Application is based on Spring Boot Framework dedicated for Java REST applications.
I've tested and build the solution on <b>Java 20</b>. It is required to build it locally and run created .jar file. 

To build executable jar file use command printed below on the root folder of the project:

```mvn clean install```

To start the project you have to run command like below (please, check the actual version of the application to set proper suffix for the jar file):

```java -jar target/Books-0.0.2-SNAPSHOT.jar```

## Available endpoints and format of payload
http://localhost:8080/swagger-ui.html - available without authentication

I've added simple Swagger to present available:
<ul>
    <li>endpoints,</li>
    <li>request and response format,</li>
    <li>returned status codes.</li> 
</ul>

There is also collection which can be imported to Postman where you can test sample requests (WSB_BE_Books.postman_collection.json).

## Database
Database used for the project is called h2 and is initialized during start of the whole application. There is no need to set up any local database server.
I've added data.sql file to the resources so the table is not empty after the start of the application (there are 4 books there inserted).

Configuration for the database is set in <b>application.properties</b> file (src/main/resources/application.properties). Feel free to connect solution with your custom database.

## Security
`GET` endpoints are available to fetch responses without additional authentication.

`POST`, `PUT`, `DELETE` endpoints are secured by Spring Security.
You can request it only if you:
<ul>
    <li>submit login form available on GET /login endpoint as html page,</li>
    <li>add Header to secured requests using Basic Authorization.</li>
</ul>
First two options require automatically added cookie with JSESSIONID which contains the state of authorized user. Third option allows to send separate requests if we know credentials.
submitting the form visible under GET /login.

Users list is already mocked with one user (`user`: `password`) but it can be handled by dedicated Repository class via database or included to the bean configuration during application build process.

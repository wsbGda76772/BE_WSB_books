# BE_WSB_books

## Framework used
Application based on Spring Boot Framework dedicated for Java REST applications.
I've tested and build the solution on <b>Java 20</b>. It is required to build it locally and run created .jar file. 

## Available endpoints and format of payload
http://localhost:8080/swagger-ui.html - available without authentication

I've added simple Swagger to present available:
<ul>
    <li>endpoints,</li>
    <li>request and response format,</li>
    <li>returned status codes.</li> 
</ul>

## Database
Database used for the project is called h2 and is initialized during start of the whole application. There is no need to set up any local database server.

Configuration for the database is set in <b>application.properties</b> file (src/main/resources/application.properties). Feel free to connect solution with your custom database.

## Security
`GET` endpoints are available to fetch responses without additional authentication.

`POST`, `PUT`, `DELETE` endpoints are secured by Spring Security. You can request it only after submitting the form visible under `GET` /login.
Users list is already mocked with one user (`user`: `password`) but it can be handled by dedicated Repository class via database or included to the bean configuration during application build process.
# Account Service

- [Account Service](#account-service)
  - [Learning Outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Create the service structure (API)](#1-create-the-service-structure-api)
      - [1.1 Description](#11-description)
      - [1.2 Objectives](#12-objectives)
      - [1.3 Examples](#13-examples)
    - [2: The authentication](#2-the-authentication)
      - [2.1 Description](#21-description)
      - [2.2 Objectives](#22-objectives)
      - [2.3 Examples](#23-examples)

## Learning Outcomes
Master the Spring Security module, learn the basics of user authentication and authorization, know how to register security events, and get acquainted with various requirements, such as modern information security standards for web applications.

## About
Companies send out payrolls to employees using corporate mail. This solution has certain disadvantages related to security and usability. In this project, put on a robe of such an employee. As you're familiar with Java and Spring Framework, you've suggested an idea of sending payrolls to the employee's account on the corporate website. The management has approved your idea, but it will be you who will implement this project. You've decided to start by developing the API structure, then define the role model, implement the business logic, and, of course, ensure the security of the service.

## Stages
### 1: Create the service structure (API)
#### 1.1 Description
It's time to plan the architecture of our service. A good plan is 50% of the result. To begin with, we will determine the functions of our service, group them, and plan the appropriate endpoints following the principles of the `REST` API:

- Authentication
  ‎1. `POST api/auth/signup` allows the user to register on the service;
  ‎2. `POST api/auth/changepass` changes a user password.

- Business functionality
  ‎1. `GET api/empl/payment` gives access to the employee's payrolls;
  ‎2. `POST api/acct/payments` uploads payrolls;
  ‎3. `PUT api/acct/payments` updates payment information.

- Service functionality
  ‎1. `PUT api/admin/user/role` changes user roles;
  ‎2. `DELETE api/admin/user` deletes a user;
  ‎3. `GET api/admin/user` displays information about all users.

To ensure the security of our service, we will also plan the distribution of roles:

||Anonymous|User|Accountant|Administrator
-|:-:|:-:|:-:|:-:
`POST api/auth/signup`|+|+|+|+
`POST api/auth/changepass`||+|+|+
`GET api/empl/payment`|-|+|+|-
`POST api/acct/payments`|-|-|+|-
`PUT api/acct/payments`|-|-|+|-
`GET api/admin/user`|-|-|-|+
`DELETE api/admin/user`|-|-|-|+
`PUT api/admin/user/role`|-|-|-|+

Later, we will reveal the purpose of the roles.

#### 1.2 Objectives
In this stage, our goal is to run a SpringBoot web application for our service and test it with one endpoint.

Create and run a SpringBoot application on the `28852` port;

Create the `POST api/auth/signup` endpoint that accepts data in the JSON format:
```json
{
   "name": "<String value, not empty>",
   "lastname": "<String value, not empty>",
   "email": "<String value, not empty>",
   "password": "<String value, not empty>"
}
```

It should return a response in the JSON format (without the password field):
```json
{
   "name": "<String value>",
   "lastname": "<String value>",
   "email": "<String value>"
}
```

If the status is `HTTP OK (200)`, then all fields are correct. If it's `HTTP Bad Request (400)`, then something is wrong. Our service must accept only corporate emails that end with @acme.com. In this stage, we do not check the authentication, so the password field may contain anything (but not empty).

#### 1.3 Examples
**Example 1**: *a POST request for api/auth/signup*

*Request body*:
```json
{
   "name": "John",
   "lastname": "Doe",
   "email": "johndoe@acme.com",
   "password": "secret"
}
```

*Response*: `200 OK`

*Response body*:
```json
{
   "name": "John",
   "lastname": "Doe",
   "email": "johndoe@acme.com",
}
```

**Example 2**: *a POST request for api/auth/signup*

*Request body*:
```json
{
   "lastname": "Doe",
   "email": "johndoe@acme.com",
   "password": "secret"
}
```

*Response*: `400 Bad Request`

*Response body*:
```json
{
   "timestamp": "<date>",
   "status": 400,
   "error": "Bad Request",
   "path": "/api/auth/signup"
}
```

**Example 3**: *a POST request for api/auth/signup*

*Request body*:
```json
{
   "name": "John",
   "lastname": "Doe",
   "email": "johndoe@google.com",
   "password": "secret"
}
```

*Response*: `400 Bad Request`

*Response body*:
```json
{
   "timestamp": "<date>",
   "status": 400,
   "error": "Bad Request",
   "path": "/api/auth/signup"
}
```

<hr/>

### 2: The authentication
#### 2.1 Description
Let's set up the authentication for our service. Of course, you can implement it yourself, but it is considered good practice to use an already tested and reliable implementation. Fortunately, Spring includes the Spring Security module that contains the right methods.

In this stage, you need to provide the HTTP Basic authentication for our `REST` service with `JDBC` implementations of `UserDetailService` for user management. You will need an endpoint for registering users at `POST api/auth/signup`.

To test the authentication, you need to add another endpoint `GET api/empl/payment/` that will be available only for authenticated users. For persistence, put users in the database. Our service will include an H2 database.

>To run the tests, the `application.properties` file should contain the following line: `spring.datasource.url=jdbc:h2:file:../service_db`.
>
>Since 2.3.0, Spring Boot hides error messages by default, to pass the tests, you need to add the following line: `server.error.include-message=always` to the `application.properties` file. For more detail, refer to the [Spring Boot Release Notes](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.3-Release-Notes#changes-to-the-default-error-pages-content).

We suggest customizing the solution for the tasks of our service. First, don't forget that we are implementing a `REST` architecture. It means that we don't have sessions. The HTTP basic mechanism is selected for authentication, and in case of an unauthorized access attempt, the service must respond with the appropriate status. Also, configure the access for the API. To do this, you need to configure the `HttpSecurity` object with the method chaining like this:
```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .httpBasic(Customizer.withDefaults())
            .exceptionHandling(ex -> ex.authenticationEntryPoint(restAuthenticationEntryPoint)) // Handle auth errors
            .csrf(csrf -> csrf.disable()) // For Postman
            .headers(headers -> headers.frameOptions().disable()) // For the H2 console
            .authorizeHttpRequests(auth -> auth  // manage access
                    .requestMatchers(HttpMethod.POST, "/api/auth/signup").permitAll()
                    // other matchers
            )
            .sessionManagement(sessions -> sessions
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // no session
            );

    return http.build();
}
```

`RestAuthenticationEntryPoint` is an instance of the class that implements the `AuthenticationEntryPoint` interface. This endpoint handles authentication errors. For example:
```java
    public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
        }
    }
```

If you don't know how to use exceptions in Spring Boot, please, take a look:
```java
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Some error meassage")
public class UserExistException extends RuntimeException { }
```

You will also need some security dependencies in Gradle:
```
dependencies {
   ... other dependencies ...
   implementation 'org.springframework.boot:spring-boot-starter-security'
}
```

#### 2.2 Objectives
Add the Spring security to your project and configure the HTTP basic authentication;

For storing users and passwords, add a JDBC implementation of `UserDetailsService` with an H2 database;

Change the `POST api/auth/signup` endpoint. It must be available to unauthorized users for registration and accepts data in the JSON format:
```json
{
   "name": "<String value, not empty>",
   "lastname": "<String value, not empty>",
   "email": "<String value, not empty>",
   "password": "<String value, not empty>"
}
```

If OK, provide the `HTTP OK` status (`200`) and the following body:
```json
{
   "id": "<Long value, not empty>",
   "name": "<String value, not empty>",
   "lastname": "<String value, not empty>",
   "email": "<String value, not empty>"
}
```

As a unique login for authentication, take the value from the `email` field. The value of the `email` field must be **case insensitive**. `Id` is a unique identifier that the service assigns to the user. If an email is occupied, the service should respond as shown below. The rest of the error messages are the same as in the previous stage:
```json
{
    "timestamp": "data",
    "status": 400,
    "error": "Bad Request",
    "message": "User exist!",
    "path": "/api/auth/signup"
}
```

Add the `GET api/empl/payment/` endpoint that allows for testing the authentication. It should be available only to authenticated users and return a response in the JSON format representing the user who has sent the request:
```json
{
   "id": "<Long value, not empty>",
   "name": "<String value, not empty>",
   "lastname": "<String value, not empty>",
   "email": "<String value, not empty>"
}
```

The `email` field must contain the user's login who has sent the request. Error message for the non-authenticated or wrong user should have the `401 (Unauthorized)` status.

#### 2.3 Examples
**Example 1**: *a POST request for api/auth/signup with the correct user*

*Request body*:
```json
{
   "name": "John",
   "lastname": "Doe",
   "email": "JohnDoe@acme.com",
   "password": "secret"
}
```

*Response*: `200 OK`

*Response body*:
```json
{
   "id": 1,
   "name": "John",
   "lastname": "Doe",
   "email": "JohnDoe@acme.com"
}
```

**Example 2**: *a POST request for api/auth/signup with the occupied email*

*Request body*:
```json
{
   "name": "John",
   "lastname": "Doe",
   "email": "johndoe@acme.com",
   "password": "secret"
}
```

*Response*: `400 Bad Request`

*Response body*:
```json
{
    "timestamp": "<data>",
    "status": 400,
    "error": "Bad Request",
    "message": "User exist!",
    "path": "/api/auth/signup"
}
```

**Example 3**: *a POST request for api/auth/signup with the wrong format of the user JSON*
```json
*Request body*:

{
   "lastname": "Doe",
   "email": "johndoe@acme.com",
   "password": "secret"
}
```

*Response*: `400 Bad Request`

*Response body*:
```json
{
   "timestamp": "<date>",
   "status": 400,
   "error": "Bad Request",
   "path": "/api/auth/signup"
}
```

**Example 4**: *a GET request for /api/empl/payment with the correct authentication, username = johndoe@acme.com, password = secret*

*Response*: `200 OK`

*Response body*:
```json
{
    "id": 1,
    "name": "John",
    "lastname": "Doe",
    "email": "johndoe@acme.com"
}
```

**Example 5**: *a GET request for /api/empl/payment with the correct authentication; username = JohnDoe@acme.com, password = secret*

*Response*: `200 OK`

*Response body*:
```json
{
    "id": 1,
    "name": "John",
    "lastname": "Doe",
    "email": "johndoe@acme.com"
}
```

**Example 6**: *a GET request for /api/empl/payment with the wrong authentication; username = johndoe@acme.com, password = no_secret*

*Response body*:
```json
{
    "timestamp": "<data>",
    "status": 401,
    "error": "Unauthorized",
    "message": "",
    "path": "/api/empl/payment"
}
```

<hr/>

[<<](../README.md)

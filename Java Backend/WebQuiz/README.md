# Web Quiz Engine with Java

- [Web Quiz Engine with Java](#web-quiz-engine-with-java)
  - [Learning outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Solving a simple quiz](#1-solving-a-simple-quiz)
      - [1.1 Description](#11-description)
      - [1.2 Objectives](#12-objectives)
      - [1.3 Examples](#13-examples)
    - [2: Lots of quizzes](#2-lots-of-quizzes)
      - [2.1 Description](#21-description)
      - [2.2 Objectives](#22-objectives)
      - [2.3 Examples](#23-examples)
    - [3: Making quizzes more interesting](#3-making-quizzes-more-interesting)
      - [3.1 Description](#31-description)
      - [3.2 Objectives](#32-objectives)
      - [3.3 Examples](#33-examples)
    - [4: Moving quizzes to DB](#4-moving-quizzes-to-db)
      - [4.1 Description](#41-description)
    - [5: User authorization](#5-user-authorization)
      - [5.1 Description](#51-description)
      - [5.2 Objectives](#52-objectives)
      - [5.3 Examples](#53-examples)

## Learning outcomes
Create a collaborative web tool for making and solving quizzes, helping you learn backend development and modern tech integration effectively.

## About
In the Internet, you can often find sites where you need to answer some questions. It can be educational sites, sites with psychological tests, job search services, or just entertaining sites like web quests. The common thing for them is the ability to answer questions (or quizzes) and then see some results. In this project, you will create a complex web service and learn about REST API, an embedded database, security, and other technologies. If you would like to continue the project, you could develop a web or mobile client for this web service on your own.

## Stages
### 1: Solving a simple quiz
#### 1.1 Description
On the Internet, you can often find sites where you need to answer questions: educational sites, sites with psychological tests, job search services, or just entertaining sites like web quests. Something they all have in common is that they permit to answer questions (or quizzes) and then see the results.

In this project, you will develop a multi-user web service for creating and solving quizzes using REST API, an embedded database, security, and other technologies. Here we will concentrate on the server side ("engine") without a user interface at all. The project stages are described in terms of the **client-server model**, where the client can be a **browser**, the **curl** tool, a REST client (like **postman**) or something else.

During the development of the web service, you will probably have to do some Google searching and additional reading. This is a normal situation, just read a few articles when implementing stages.

After you complete this project, you will have a clear understanding of **backend** development. You'll also know how to combine various modern technologies to get a great result. If you continue the work on the project, you can also develop a web/mobile client for this web service.

At the first stage, you need to develop a simple JSON API that always returns the same quiz to be solved. The API should support only two operations: getting the quiz and solving it by passing an answer. Each operation is described in more detail below.

Once the stage is completed, you will have a working web service with a comprehensive API.

To test your API, you may write Spring Boot tests, or use a rest client like [postman](https://www.getpostman.com/product/api-client) or [the curl tool](https://gist.github.com/subfuzion/08c5d85437d5d4f00e58). GET requests can be tested by accessing the URL in your browser. You can also check your application in the browser using [reqbin](https://reqbin.com/).

#### 1.2 Objectives
Create `GET /api/quiz` endpoint that returns a quiz object in JSON format. The quiz should have exactly three fields: `title` (string) `text` (string) and `options` (array). To get the quiz, the client sends the `GET` request and the server responds with the following JSON structure:
```json
{
  "title": "The Java Logo",
  "text": "What is depicted on the Java logo?",
  "options": ["Robot","Tea leaf","Cup of coffee","Bug"]
}
```

In your API, the names of the attributes must be exactly as specified above (`title`, `text`, `options`) but you can assign them any values of the appropriate type. The quiz should contain four items in the `options` array. The correct answer must be the **third option**, which means that since the indexes in the array start from zero, the **index of the correct answer must be 2**.

> There is no need to force your server to respond a JSON with line breaks and additional spaces. This is used only to demonstrate the response in a human-readable format. Actually, your server returns a long single-line JSON: `{"title":"The Java Logo","text":"What is depicted on the Java logo?","options":["Robot","Tea leaf","Cup of coffee","Bug"]}`.

Create `POST /api/quiz` endpoint. To solve the quiz, the client needs to pass the `answer` request parameter representing the index of the chosen option from the `options` array. Remember, in our service indexes start from zero.

The server should return JSON with two fields: `success` (`true` or `false`) and `feedback` (just a string). There are two possible responses from the server:

- If the passed answer is correct (`POST` to `/api/quiz?answer=2`):
```json
{
  "success":true,
  "feedback":"Congratulations, you're right!"
}
```

- If the answer is incorrect (e.g., `POST` to `/api/quiz?answer=1`):
```json
{
  "success":false,
  "feedback":"Wrong answer! Please, try again."
}
```

You can write any other strings in the `feedback` field, but the names of the fields and the `true`/`false` values must be as provided above.

#### 1.3 Examples
**Example 1**: *getting the quiz*: <br>
*Request*: `GET /api/quiz` <br>
*Response body*:
```json
{
  "title": "The Java Logo",
  "text": "What is depicted on the Java logo?",
  "options": ["Robot","Tea leaf","Cup of coffee","Bug"]
}
```

**Example 2**: *submitting the correct answer*: <br>
*Request*: `POST /api/quiz?answer=2` <br>
*Response body*:
```json
{
  "success":true,
  "feedback":"Congratulations, you're right!"
}
```

**Example 3**: *submitting a wrong answer*: <br>
*Request*: `POST /api/quiz?answer=1`
*Response body*:
```json
{
  "success":false,
  "feedback":"Wrong answer! Please, try again."
}
```

<hr/>

### 2: Lots of quizzes
#### 2.1 Description
At this stage, you will improve the web service to create, get and solve lots of quizzes, not just a single one. All quizzes should be stored in the service's memory, without an external storage.

The format of requests and responses will be similar to the first stage, but you will make the API more REST-friendly and extendable. You will add four operations:

- `POST` `/api/quizzes` to create a new quiz;
- `GET` `/api/quizzes/{id}` to get a quiz by its id;
- `GET` `/api/quizzes` to get all available quizzes; and
- `POST` `/api/quizzes/{id}/solve?answer={index}` to solve a specific quiz.

Each of these operations are described below in detail.

#### 2.2 Objectives
- Create the `POST` `/api/quizzes` endpoint for adding a new quiz. The client needs to send a JSON as the request's body that should contain the four fields: `title` (a string), `text` (a string), `options` (an array of strings) and `answer` (integer index of the correct option). At this moment, all the keys are optional:
```json
{
  "title": "<string>",
  "text": "<string>",
  "options": ["<string 1>","<string 2>","<string 3>", ...],
  "answer": <integer>
}
```

If `answer` equals `2`, it corresponds to the third item from the `options` array (i.e. `"<string 3>"`).

The server response is a JSON with four fields: `id`, `title`, `text` and `options`:
```json
{
  "id": <integer>,
  "title": "<string>",
  "text": "<string>",
  "options": ["<string 1>","<string 2>","<string 3>", ...]
}
```

The `id` field is a generated unique integer identifier for the quiz. Also, the response may or may not include the `answer` field depending on your wishes. This is not very important for this operation.

At this moment, it is admissible if a creation request does not contain some quiz data. In the next stages, we will improve the service to avoid some server errors.

- Create the `GET` `/api/quizzes/{id}` endpoint to get a quiz by `id`. The server must response with a JSON in the following format:
```json
{
  "id": <integer>,
  "title": "<string>",
  "text": "<string>",
  "options": ["<string 1>","<string 2>","<string 3>", ...]
}
```

>The response **must not** include the `answer` field, otherwise, any user will be able to find the correct answer for any quiz.

If a quiz with the specified id does not exist, the server should return the `404 (Not found)` status code.

- Create the `GET` `/api/quizzes` endpoint to get all existing quizzes in the service. The response contains a JSON array of quizzes like the following:
```json
[
  {
    "id": <integer>,
    "title": "<string>",
    "text": "<string>",
    "options": ["<string 1>","<string 2>","<string 3>", ...]
  },
  {
    "id": <integer>,
    "title": "<string>",
    "text": "<string>",
    "options": ["<string 1>","<string 2>", ...]
  }
]
```

>The response **must not** include the `answer` field, otherwise, any user will be able to find the correct answer for any quiz.

If there are no quizzes, the service returns an empty JSON array: `[]`.

In both cases, the status code is `200 (OK)`.

- Create the `POST` `/api/quizzes/{id}/solve?answer={index}` endpoint to solve a quiz by its id. The client passes the `answer` request parameter which is the index of a chosen option from `options` array. As before, it starts from zero.

The service returns a JSON with two fields: `success` (`true` or `false`) and `feedback` (just a string).

If the passed answer is correct, e.g., `POST` to `/api/quizzes/1/solve?answer=2`:
```json
{
  "success": true,
  "feedback": "Congratulations, you're right!"
}
```

If the answer is incorrect e.g., `POST` to `/api/quizzes/1/solve?answer=1`:
```json
{
  "success": false,
  "feedback": "Wrong answer! Please, try again."
}
```

If a quiz with the specified id does not exist, the server returns the `404 (Not found)` status code.

You can write any other strings in the `feedback` field, but the names of fields and the `true`/`false` values must match this example.

#### 2.3 Examples
**Example 1**: *creating a new quiz:*

*Request* `POST /api/quizzes`

*Request body*
```json
{
  "title": "The Java Logo",
  "text": "What is depicted on the Java logo?",
  "options": ["Robot","Tea leaf","Cup of coffee","Bug"],
  "answer": 2
}
```

*Response body*
```json
{
  "id": 1,
  "title": "The Java Logo",
  "text": "What is depicted on the Java logo?",
  "options": ["Robot","Tea leaf","Cup of coffee","Bug"]
}
```

**Example 2**: *getting an existing quiz by id:*

*Request* `GET /api/quizzes/1`

*Response body*
```json
{
  "id": 1,
  "title": "The Java Logo",
  "text": "What is depicted on the Java logo?",
  "options": ["Robot","Tea leaf","Cup of coffee","Bug"]
}
```

**Example 3**: *getting a non-existing quiz by id:*

*Request* `GET /api/quizzes/15`

*Response*: `404 NOT FOUND`

**Example 4**: *getting all quizzes:*

*Request* `GET /api/quizzes`

*Response body*
```json
[
  {
    "id": 1,
    "title": "The Java Logo",
    "text": "What is depicted on the Java logo?",
    "options": ["Robot","Tea leaf","Cup of coffee","Bug"]
  },
  {
    "id": 2,
    "title": "The Ultimate Question",
    "text": "What is the answer to the Ultimate Question of Life, the Universe and Everything?",
    "options": ["Everything goes right","42","2+2=4","11011100"]
  }
]
```

**Example 5**: *solving an existing quiz with a correct answer:*

*Request* `POST /api/quizzes/1/solve?answer=2`

*Response body*
```json
{
  "success": true,
  "feedback": "Congratulations, you're right!"
}
```

**Example 6**: *solving an existing quiz with a wrong answer:*

*Request* `POST /api/quizzes/1/solve?answer=1`

*Response body*
```json
{
  "success": false,
  "feedback": "Wrong answer! Please, try again."
}
```

**Example 7**: *solving an non-existing quiz:*

*Request* `POST /api/quizzes/15/solve?answer=1`

*Response*: `404 NOT FOUND`

<hr/>

### 3: Making quizzes more interesting
#### 3.1 Description
Currently, your service allows creating new quizzes, but there may be problems if the client didn't provide all the quiz data. In such cases, the service will create an incorrect unsolvable quiz which is very frustrating for those who are trying to solve it.

At this stage, you should fix this so that the service does not accept incorrect quizzes. Another task is to make quizzes more interesting by supporting the arbitrary number of correct options (from zero to all). It means that to solve a quiz, the client needs to send all correct options at once, or zero if all options are wrong.

You may add this dependency to your build.gradle file to enable Spring validation:
```
implementation "org.springframework.boot:spring-boot-starter-validation"
```

There are only two modified operations for creating and solving quizzes. All other operations should not be changed or deleted.

#### 3.2 Objectives
1. Update handing of `POST` requests sent a the `/api/quizzes` endpoint. The requests must contain a JSON as the request's body with the four fields:

- `title`: a string, **required**;
- `text`: a string, **required**;
- `options`: an array of strings, required, should contain at least **2** items;
- `answer`: an array of integer indexes of correct options, can be absent or empty if all options are wrong.

Here is the new structure of the request body:
```json
{
  "title": "<string, not null, not empty>",
  "text": "<string, <not null, not empty>",
  "options": ["<string 1>","<string 2>","<string 3>", ...],
  "answer": [<integer>,<integer>, ...]
}
```

For example, if `answer` equals to `[0,2]` it means that the first and the third item from the `options` array (`"<string 1>"` and `"<string 3>"`) are correct.

The server response is a JSON with four fields: `id`, `title`, `text` and `options`. Here is an example:
```json
{
  "id": <integer>,
  "title": "<string>",
  "text": "<string>",
  "options": ["<string 1>","<string 2>","<string 3>", ...]
}
```

The `id` field is a generated unique integer identifier for the quiz. Also, the response may or may not include the `answer` field depending on your wishes. This is not very important for this operation.

If the request JSON does not contain `title` or `text`, or they are empty strings (`""`), then the server should respond with the `400 (Bad request)` status code. If the number of options in the quiz is less than 2, the server returns the same status code.

2. Update handling of `POST` requests to the `/api/quizzes/{id}/solve` endpoint. To solve a quiz, the client sends the a JSON that contains the single key `"answer"` which value is and array of indexes of all chosen options as the answer:
```json
{
  "answer": [<integer>, <integer>, ...]
}
```

As before, indexes start from zero. It is also possible to send an empty array `[]` since some quizzes may not have correct options.

The service returns a JSON with two fields: `success` (`true` or `false`) and `feedback` (just a string). There are three possible responses.

- If the passed answer is correct:
```json
{
  "success":true,
  "feedback":"Congratulations, you're right!"
}
```

- If the answer is incorrect:
```json
{
  "success":false,
  "feedback":"Wrong answer! Please, try again."
}
```

- If the specified quiz does not exist, the server returns the `404 NOT FOUND` status code.

You can write any other strings in the `feedback` field, but the names of fields and the `true`/`false` values must match this example.

Follow these recommendations to avoid problems during implementing the stage:

- Use @NotBlankbean validation annotations to validate the content oftitle and text.
- Use @NotNull and @Size annotations to validate the size of options.

#### 3.3 Examples
**Example 1**: *creating a new quiz with a valid request body*:

*Request* `POST /api/quizzes`

*Request body*
```json
{
  "title": "The Java Logo",
  "text": "What is depicted on the Java logo?",
  "options": ["Robot","Tea leaf","Cup of coffee","Bug"],
  "answer": [2]
}
```

*Response body*
```json
{
  "id": 1,
  "title": "The Java Logo",
  "text": "What is depicted on the Java logo?",
  "options": ["Robot","Tea leaf","Cup of coffee","Bug"]
}
```

**Example 2**: *creating a new quiz with a missing title*:

*Request* `POST /api/quizzes`

*Request body*
```json
{
  "text": "What is depicted on the Java logo?",
  "options": ["Robot","Tea leaf","Cup of coffee","Bug"],
  "answer": [2]
}
```

Response: 400 BAD REQUEST

**Example 3**: *creating a new quiz with an empty title*:

*Request* `POST /api/quizzes`

*Request body*
```json
{
  "title": "",
  "text": "What is depicted on the Java logo?",
  "options": ["Robot","Tea leaf","Cup of coffee","Bug"],
  "answer": [2]
}
```

*Response*: `400 BAD REQUEST`

**Example 4**: *creating a new quiz with an empty options array*:

*Request* `POST /api/quizzes`

*Request body*
```json
{
  "title": "The Java Logo",
  "text": "What is depicted on the Java logo?",
  "options": [],
  "answer": [2]
}
```

Response: `400 BAD REQUEST`

**Example 5**: *solving an existing quiz with a correct answer*:

*Request* `POST /api/quizzes/1/solve`

*Request body*
```json
{
  "answer": [2]
}
```

*Response body*
```json
{
  "success": true,
  "feedback": "Congratulations, you're right!"
}
```

**Example 6**: *solving an existing quiz with a wrong answer*:

*Request* `POST /api/quizzes/1/solve`

*Request body*
```json
{
  "answer": [0]
}
```

*Response body*
```json
{
  "success": false,
  "feedback": "Wrong answer! Please, try again."
}
```

**Example 7**: *solving an non-existing quiz*:

*Request* `POST /api/quizzes/15/solve`

*Request body*
```json
{
  "answer": [2]
}
```

*Response*: `404 NOT FOUND`

<hr/>

### 4: Moving quizzes to DB
#### 4.1 Description
At this stage, you will permanently store the data in a database, so that after restarting the service you will not lose all quizzes created by the users. You don't need to change the API of your service at this stage.

We recommend you use the H2 database in the disk-based storage mode (not in-memory).

To start working with it, just add a couple of new dependencies in your `build.gradle` file:
```
dependencies {
    // ...
    runtimeOnly 'com.h2database:h2'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    // ...
}
```

The first dependency will allow using the H2 database in your application, and the second will allow using Spring Data JPA.

You also need to configure the database inside the `application.properties` file. Do not change the database path.
```
spring.datasource.url=jdbc:h2:file:../quizdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

spring.h2.console.enabled=true
spring.h2.console.settings.trace=false
spring.h2.console.settings.web-allow-others=false
```

This config will automatically create the database and update tables inside it.

You should use exactly the same name for DB: `quizdb`.

If you want to see SQL statements generated by Spring ORM, just add the following line in the properties file:
```
spring.jpa.show-sql=true
```

To start using this database, you need to map your classes to database tables using JPA annotations and Spring repositories.

You can use any tables in your database to complete this stage. The main thing is that when you restart the service, quizzes should not be lost. Our tests will create and get them via the API developed at the previous stages.

Follow these recommendations to avoid problems during implementing the stage:

- Use `@ElementCollection(fetch = FetchType.EAGER)` on collections in entities.
- Use `@Fetch(value = FetchMode.SUBSELECT)` either on answer or options in the quiz entity.

<hr/>

### 5: User authorization
#### 5.1 Description
Your service already has a well-designed API and stores all the quizzes in the database. At this stage, you will improve the service to support users and the authorization process. This will allow you to provide different privileges to the users and understand what do they do in the service.

Here are two operations to be added:

- **register a new user**, which accepts an email as the login and a password;
- **deleting a quiz** created by the current user.

All the previously developed operations should not be changed. As before, when creating a new quiz, the service checks the following rules: the fields `title` and `text` exist and they are not empty, and the `options` array has two or more items. If at least one of these conditions is not satisfied, the service returns the `400 (BAD REQUEST)` status code. As before, server responses for getting quizzes should not include answers for the quizzes.

Add Spring Security starter to your build.gradle file to protect the secure endpoints:
```
implementation 'org.springframework.boot:spring-boot-starter-security'
```

>For the testing reasons, make `POST /actuator/shutdown` endpoint accessible without authentication.

The main change is the accessibility of these operations. Now, to perform any operations with quizzes (**create**, **solve**, **get one**, **get all**, **delete**), the user has to be registered and then authorized via **HTTP Basic Auth** by sending their email and password for each request. Otherwise, the service returns the `401 (UNAUTHORIZED)` status code. Thus, the only operation that does not require authorization is the registration.

>Do not store the actual password in the database! Instead, configure password encryption using `BCrypt` or some other algorithm via Spring Security.

#### 5.2 Objectives
1. Create the `POST` `/api/register` endpoint. To register a new user, the client needs to send a JSON to this endpoint in the following format:
```json
{
  "email": "<username>@<domain>.<extension>",
  "password": "<string, at least 5 characters long>"
}
```

The service returns `200 (OK)` status code if the registration has been completed successfully.

If the `email` is already taken by another user, the service will return the `400 (BAD REQUEST)` status code.

Here are some additional restrictions to the format of user credentials:

- the email must have a valid format (with `@` and `.`);
- the password must have **at least five** characters.

If any of them is not satisfied, the service must also return the `400 (BAD REQUEST)` status code.

All the following operations need a registered user to be successfully completed.

2. Create the `DELETE` request to `/api/quizzes/{id}` to allow a user to delete their quiz.

If the operation was successful, the service returns the `204 (NO CONTENT)` status code without any content.

If the specified quiz does not exist, the server returns `404 (NOT FOUND)`. If the specified user is not the author of this quiz, the response is the `403 (FORBIDDEN)` status code.

**Additional ideas**
If you would like your service to support more operations, add `PUT` or `PATCH` to update existing quizzes in the similar way as `DELETE`. Our tests will not verify these operations..

#### 5.3 Examples
**Example 1**: *registering a new user with a valid request body:*

*Request*: `POST /api/register`

*Request body*:
```json
{
  "email": "test@mail.org",
  "password": "strongpassword"
}
```

*Response*: `200 OK`

**Example 2**: *registering a new user with a valid request body but the email address is already taken:*

*Request*: `POST /api/register`

*Request body*:
```json
{
  "email": "test@mail.org",
  "password": "strongpassword"
}
```

*Response*: `400 BAD REQUEST`

**Example 3**: *registering a new user with an invalid email:*

*Request*: `POST /api/register`

*Request body*:
```json
{
  "email": "test@mailorg",
  "password": "strongpassword"
}
```

*Response*: `400 BAD REQUEST`

**Example 4**: *registering a new user with a too short password:*

*Request*: `POST /api/register`

*Request body*:
```json
{
  "email": "test@mail.org",
  "password": "123"
}
```

*Response*: `400 BAD REQUEST`

**Example 5**: *requesting a list of quizzes without providing a valid authentication:*

*Request*: `GET /api/quizzes`

*Response*: `401 UNAUTHORIZED`

**Example 6**: *deleting a quiz created by the same user, providing a valid authentication: email=test@mail.org and password=strongpassword.*

*Request*: `DELETE /api/quizzes/2`

*Response*: `204 NO CONTENT`

**Example 6**: *deleting a non-existing quiz, providing a valid authentication: email=test@mail.org and password=strongpassword:*

*Request*: `DELETE /api/quizzes/20`

*Response*: `404 NOT FOUND`

**Example 6**: *deleting a quiz created by another user, providing a valid authentication: email=test@mail.org and password=strongpassword:*

*Request*: `DELETE /api/quizzes/5`

*Response*: `403 UNAUTHORIZED`

<hr/>

[<<](../README.md)

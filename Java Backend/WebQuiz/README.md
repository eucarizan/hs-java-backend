# Web Quiz Engine with Java

- [Web Quiz Engine with Java](#web-quiz-engine-with-java)
  - [Learning outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Solving a simple quiz](#1-solving-a-simple-quiz)
      - [1.1 Description](#11-description)
      - [1.2 Objectives](#12-objectives)
      - [1.3 Examples](#13-examples)

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

[<<](../README.md)

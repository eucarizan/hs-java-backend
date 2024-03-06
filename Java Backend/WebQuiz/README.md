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


[<<](../README.md)

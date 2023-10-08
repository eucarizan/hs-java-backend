# Cinema Room REST Service

- [Cinema Room REST Service](#cinema-room-rest-service)
  - [Learning outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: The show begins](#1-the-show-begins)
      - [1.1 Description](#11-description)
      - [1.2 Objectives](#12-objectives)
      - [1.3 Examples](#13-examples)
    - [2. Take your seat](#2-take-your-seat)
      - [2.1 Description](#21-description)
      - [2.2 Objectives](#22-objectives)
      - [2.3 Examples](#23-examples)
    - [3. A change of plans](#3-a-change-of-plans)
      - [3.1 Description](#31-description)
      - [3.2 Objectives](#32-objectives)
      - [3.3 Examples](#33-examples)
    - [4. The statistics](#4-the-statistics)
      - [4.1 Description](#41-description)
      - [4.2 Objectives](#42-objectives)
      - [4.3 Examples](#43-examples)

## Learning outcomes
In this project, you will create a simple Spring REST service that will help you manage a small movie theater. It will handle HTTP requests in controllers, create services, and respond with JSON objects.

## About
Always wanted to have your private movie theater and screen only the movies you like? You can buy a fancy projector and set it up in a garage, but how can you sell tickets? The idea of a ticket booth is old-fashioned, so let's create a special service for that! Make good use of Spring and write a REST service that can show the available seats, sell and refund tickets, and display the statistics of your venue. Pass me the popcorn, please!

## Stages
### 1: The show begins
#### 1.1 Description
There are many fun activities on the planet Earth, and one of them is going to the movies. It is arguably the most accessible, inclusive, and fulfilling entertainment. Bring your friends or loved ones — each movie is a whole new adventure waiting to be experienced.

Let's make our virtual movie theater with the help of a REST service. Our movie theater has 9 rows with 9 seats each. In this stage, you need to create a simple endpoint that will return the information about the cinema in JSON format.

#### 1.2 Objectives
Implement the `/seats` endpoint that handles `GET` requests and returns the information about the movie theatre.

The response should contain information about the rows, columns, and available seats. The response is a JSON object and has the following format:

```json
{
   "total_rows":5,
   "total_columns":6,
   "available_seats":[
      {
         "row":1,
         "column":1
      },

      ........

      {
         "row":5,
         "column":5
      },
      {
         "row":5,
         "column":6
      }
   ]
}
```

Our cinema room has 9 rows with 9 seats each, so the total number of respective rows and columns also amounts to 9 each.

Note that the `available_seats` array contains 81 elements, as there are 81 seats in the room.

#### 1.3 Examples
**Example 1:** _a `GET /seats` request_
*Response body:*

```json
{
   "total_rows":9,
   "total_columns":9,
   "available_seats":[
      {
         "row":1,
         "column":1
      },
      {
         "row":1,
         "column":2
      },
      {
         "row":1,
         "column":3
      },

      ........

      {
         "row":9,
         "column":8
      },
      {
         "row":9,
         "column":9
      }
   ]
}
```
<hr>

### 2. Take your seat
#### 2.1 Description
Movie-goers should be able to check the availability of seats before purchasing a ticket. In this stage, you need to add an endpoint to check and purchase an available ticket. If the ticket has been purchased or the request contains wrong information about the ticket, return an error message.

#### 2.2 Objectives
Implement the `/purchase` endpoint that handles `POST` requests and marks a booked ticket as purchased.

A request should contain the following data:

- row — the row number;
- column — the column number.

Take these variables and check if the specified ticket is available. If the ticket is booked, mark the seat as purchased and don't show it in the list.

If the purchase is successful, the response body should be as follows:
```json
{
  "row": 5,
  "column": 7,
  "price": 8
}
```

The ticket price is determined by a row number. If the row number is less or equal to 4, set the price at **10**. All other rows cost **8** per seat.

If the seat is taken, respond with a `400 (Bad Request)` status code. The response body should contain the following:
```json
{
  "error": "The ticket has been already purchased!"
}
```

If users pass a wrong row/column number, respond with a `400` status code and the following line:
```json
{
  "error": "The number of a row or a column is out of bounds!"
}
```

Show the ticket price when the `/seats` endpoint is accessed. See the first example for more details.

#### 2.3 Examples
**Example 1:** _a `GET /seats` request_

_Response body:_
```json
{
   "rows": 9,
   "columns": 9,
   "seats": [
      {
         "row": 1,
         "column": 1,
         "price": 10
      },
      {
         "row": 1,
         "column": 2,
         "price": 10
      },
      {
         "row": 1,
         "column": 3,
         "price": 10
      },

      ........

      {
         "row": 9,
         "column": 8,
         "price": 8
      },
      {
         "row": 9,
         "column": 9,
         "price": 8
      }
   ]
}
```

**Example 2:** _a `POST /purchase` correct request_

_Request body:_
```json
{
    "row": 3,
    "column": 4
}
```

_Response body:_
```json
{
    "row": 3,
    "column": 4,
    "price": 10
}
```

**Example 3:** _a `POST /purchase` request, the ticket is already booked_

_Request body:_
```json
{
    "row": 3,
    "column": 4
}
```

_Response body:_
```json
{
  "error": "The ticket has been already purchased!"
}
```

**Example 4:** _a POST /purchase request, a wrong row number_

_Request body:_
```json
{
    "row": 15,
    "column": 4
}
```

_Response body:_
```json
{
    "error": "The number of a row or a column is out of bounds!"
}
```
<hr>

### 3. A change of plans
#### 3.1 Description
We live in a fast world, and our plans may change very quickly. Let's add the ability to refund a ticket if a customer can't come and watch a movie. We will use tokens to secure the ticket refund process.

#### 3.2 Objectives
Change the JSON response when a customer purchases a ticket by making a `POST` request to the `/purchase` endpoint. Turn it into the following format:
```json
{
    "token": "00ae15f2-1ab6-4a02-a01f-07810b42c0ee",
    "ticket": {
        "row": 1,
        "column": 1,
        "price": 10
    }
}
```

We recommend using the `randomUUID()` method of the `UUID` class to generate tokens. Take a look at this [UUID Guide](https://www.baeldung.com/java-uuid) by Baeldung if you're interested in more detail.

Implement the `/return` endpoint, which will handle `POST` requests and allow customers to refund their tickets.

The request should have the `token` feature that identifies the ticket in the request body. Once you have the token, you need to identify the ticket it relates to and mark it as available. The response body should be as follows:
```json
{
    "ticket": {
        "row": 1,
        "column": 1,
        "price": 10
    }
}
```

The `ticket` should contain the information about the returned ticket.

If you cannot identify the ticket by the token, make your program respond with a `400` status code and the following response body:
```json
{
    "error": "Wrong token!"
}
```

#### 3.3 Examples
**Example 1:** *a correct `POST /purchase` request*

*Request body:*
```json
{
    "row": 3,
    "column": 4
}
```

*Response body:*
```json
{
    "token": "e739267a-7031-4eed-a49c-65d8ac11f556",
    "ticket": {
        "row": 3,
        "column": 4,
        "price": 10
    }
}
```

**Example 2:** *`POST /return` with the correct token*

`Request body:`
```json
{
    "token": "e739267a-7031-4eed-a49c-65d8ac11f556"
}
```

**Response body:**
```json
{
    "ticket": {
        "row": 1,
        "column": 2,
        "price": 10
    }
}
```

**Example 3:** *`POST /return` with an expired token*
*Request body:*
```json

{
    "token": "e739267a-7031-4eed-a49c-65d8ac11f556"
}
```

*Response body:*
```json
{
    "error": "Wrong token!"
}
```
<hr>

### 4. The statistics
#### 4.1 Description
Your REST service knows how to show available tickets, sell them, and make a refund. Let's add statistics available only to the theatre managers.

#### 4.2 Objectives
Implement the `/stats` endpoint that will handle `GET` requests with URL parameters. If the URL parameters contain a `password` key with a `super_secret` value, return the movie theatre statistics in the following format:

```json
{
    "income": 0,
    "available": 81,
    "purchased": 0
}
```

Take a look at the description of keys:

- `income` — shows the total income of sold tickets.
- `available` — shows how many seats are available.
- `purchased` — shows how many tickets were purchased.

If the parameters don't contain a password key or a wrong value has been passed, respond with a 401 status code. The response body should contain the following:

```json
{
    "error": "The password is wrong!"
}
```

#### 4.3 Examples
**Example 1:** _a `GET /stats` request with no parameters_

*Response body:*
```json
{
    "error": "The password is wrong!"
}
```

**Example 2:** *a `GET /stats` request with the correct password*

*Response body:*
```json
{
    "income": 30,
    "available": 78,
    "purchased": 3
}
```


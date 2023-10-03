# Cinema Room REST Service

- [Cinema Room REST Service](#cinema-room-rest-service)
  - [Learning outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: The show begins](#1-the-show-begins)
      - [1.1 Description](#11-description)
      - [1.2 Objectives](#12-objectives)
      - [1.3 Examples](#13-examples)

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

<!-- ### 3 -->
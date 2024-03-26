# Account Service

- [Account Service](#account-service)
  - [Learning Outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Create the service structure (API)](#1-create-the-service-structure-api)
      - [1.1 Description](#11-description)
      - [1.2 Objectives](#12-objectives)
      - [1.3 Examples](#13-examples)

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

[<<](../README.md)

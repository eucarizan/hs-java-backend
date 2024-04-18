# Recipes

- [Recipes](#recipes)
  - [Learning outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: First recipe](#1-first-recipe)
      - [1.1 Description](#11-description)
      - [1.2 Theory](#12-theory)
      - [1.3 Objectives](#13-objectives)
      - [1.4 Examples](#14-examples)
    - [2: Multiple recipes](#2-multiple-recipes)
      - [2.1 Description](#21-description)
      - [2.2 Objectives](#22-objectives)
      - [2.3 Examples](#23-examples)
    - [3: Store a recipe](#3-store-a-recipe)
      - [3.1 Description](#31-description)
      - [3.2 Objectives](#32-objectives)
      - [3.3 Examples](#33-examples)
    - [4: Sort \& update](#4-sort--update)
      - [4.1 Description](#41-description)
      - [4.2 Objectives](#42-objectives)
      - [4.3 Examples](#43-examples)
    - [5: More chefs to the table](#5-more-chefs-to-the-table)
      - [5.1 Description](#51-description)
      - [5.2 Objectives](#52-objectives)
      - [5.3 Examples](#53-examples)

## Learning outcomes
Get to know the backend development. Use Spring Boot to complete this project. Learn about JSON, REST API, Spring Boot Security, H2 database, LocalDateTime, Project Lombok, and other concepts useful for the backend.

## About
An urge to cook something special is too hard to resist sometimes. But what if you lost the recipe? Or your beloved grandma is too busy to answer a call and remind you of your favorite cake recipe? Let's make a program that stores all recipes in one place. Create a multi-user web service with Spring Boot that allows storing, retrieving, updating, and deleting recipes.

## Stages
### 1: First recipe
#### 1.1 Description
We all were in a situation when we wanted to cook something special but couldn't remember a recipe. Let's create a program that can store all recipes in one place. The program is a multi-user web service based on Spring Boot that allows storing, retrieving, updating, and deleting recipes.

In the first stage, you'll implement a simple service that supports two operations: adding (`POST /api/recipe`), and retrieving (`GET /api/recipe`) a recipe. The service will be able to store only one recipe at a time. Every new recipe added via `POST` request will override the previous one. We will improve the service to support multiple recipes in the stages to come.

A recipe includes 4 fields: `name` , `description`, `ingredients`, `directions`. Here's an example of the `Fresh Mint Tea` recipe:

```json
{
   "name": "Fresh Mint Tea",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": "boiled water, honey, fresh mint leaves",
   "directions": "1) Boil water. 2) Pour boiling hot water into a mug. 3) Add fresh mint leaves. 4) Mix and let the mint leaves seep for 3-5 minutes. 5) Add honey and mix again."
}
```

#### 1.2 Theory
With Spring Boot, we need to write data classes with a lot of getters, setters, and constructors; having a readable `toString` is also a good idea. Getters and setters are often simple, they return or store a value. Manually writing these methods may be tedious and lead to errors. To simplify this process, we can use a very simple but powerful [Project Lombok](https://hyperskill.org/learn/step/13983) library. It can generate all these methods during compilation and reduces the number of lines and bugs. It also improves code readability and maintainability. Take a look at the example below:

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
class Animal {
   String name;
   int age;
   int weight;
}
```

`@Data` annotation automatically generates getters (for all fields), setters (for all non-final fields), `hashCode`, `equals`, and a readable `toString` method. Second and third annotation generates constructors. The annotations can be different — if you want to know more about this library, take a look at the link above. The library is already imported; feel free to use this library not only with Spring Boot but also with any other Java program.

The tests won't check whether you use Project Lombok or not.

#### 1.3 Objectives
Implement two endpoints:

- `POST /api/recipe` receives a recipe as a JSON object and overrides the current recipe.
- `GET /api/recipe` returns the current recipe as a JSON object.

The initial recipe can have any form.

#### 1.4 Examples
**Example 1:** `POST /api/recipe` request with the following body:
```json
{
   "name": "Fresh Mint Tea",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": "boiled water, honey, fresh mint leaves",
   "directions": "1) Boil water. 2) Pour boiling hot water into a mug. 3) Add fresh mint leaves. 4) Mix and let the mint leaves seep for 3-5 minutes. 5) Add honey and mix again."
}
```

**Example 2:** Response for a `GET /api/recipe` request:
```json
{
   "name": "Fresh Mint Tea",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": "boiled water, honey, fresh mint leaves",
   "directions": "1) Boil water. 2) Pour boiling hot water into a mug. 3) Add fresh mint leaves. 4) Mix and let the mint leaves seep for 3-5 minutes. 5) Add honey and mix again."
}
```
<hr/>

### 2: Multiple recipes
#### 2.1 Description
Our service can store only one recipe at a time which is not very convenient. In this stage, improve the service to store a lot of recipes and access recipes by a unique `id`. Some changes in the recipe structure are also required.

The new structure of a recipe includes the same 4 fields, but the type of two of them is different. `ingredients` and `directions` should now be arrays. Here's an example of the new structure:

```json
{
   "name": "Warming Ginger Tea",
   "description": "Ginger tea is a warming drink for cool weather, ...",
   "ingredients": ["1 inch ginger root, minced", "1/2 lemon, juiced", "1/2 teaspoon manuka honey"],
   "directions": ["Place all ingredients in a mug and fill with warm water (not too hot so you keep the beneficial honey compounds in tact)",
   "Steep for 5-10 minutes", "Drink and enjoy"]
}
```

#### 2.2 Objectives
Rearrange the existing endpoints; the service should support the following:

- `POST /api/recipe/new` receives a recipe as a JSON object and returns a JSON object with one `id` field. This is a uniquely generated number by which we can identify and retrieve a recipe later. The status code should be `200 (Ok)`.
- `GET /api/recipe/{id}` returns a recipe with a specified `id` as a JSON object (where `{id}` is the id of a recipe). The server should respond with the `200 (Ok)` status code. If a recipe with a specified `id` does not exist, the server should respond with `404 (Not found)`.

#### 2.3 Examples
**Example 1**: `POST /api/recipe/new` request with the following body:
```json
{
   "name": "Fresh Mint Tea",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves",
      "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}
```

Response:
```json
{
   "id": 1
}
```

**Example 2**: `GET /api/recipe/1` request

Response:
```json
{
   "name": "Fresh Mint Tea",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves",
      "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}
```

**Example 3**: `GET /api/recipe/999` request

Status code: `404 (Not found)`

<hr/>

### 3: Store a recipe
#### 3.1 Description
In the previous stage, we have improved our service, so it can handle a lot of recipes. But when we close our program, it deletes all recipes. In this stage, you'll implement one of the main features of the service – connect the service to a database and store the recipes there. No more lost recipes!

You will also need a new endpoint that will allow deleting a recipe by the recipe `id`. Make sure that the service accepts only valid recipes – recipes without directions or ingredients are frustrating. We won't change the recipe structure in this stage.

#### 3.2 Objectives
First of all, include all necessary dependencies and configurations in the `build.gradle` and `application.properties` files.

For testing reasons, the `application.properties` file should contain the following line with the database name:
```
spring.datasource.url=jdbc:h2:file:../recipes_db
```

The service should support the same endpoints as in the previous stage:

- `POST /api/recipe/new` receives a recipe as a JSON object and returns a JSON object with one `id` field;
- `GET /api/recipe/{id}` returns a recipe with a specified `id` as a JSON object.

To complete the stage you need to add the following functionality:

- Store all recipes permanently in a database: after a server restart, all added recipes should be available to a user;
- Implement a new `DELETE /api/recipe/{id}` endpoint. It deletes a recipe with a specified `{id}`. The server should respond with the `204 (No Content)` status code. If a recipe with a specified id does not exist, the server should return `404 (Not found)`;
- The service should accept only valid recipes – all fields are obligatory, `name` and `description` shouldn't be blank, and JSON arrays should contain at least one item. If a recipe doesn't meet these requirements, the service should respond with the `400 (Bad Request)` status code.

#### 3.3 Examples
**Example 1**: `POST /api/recipe/new` request
```json
{
   "name": "Warming Ginger Tea",
   "description": "Ginger tea is a warming drink for cool weather, ...",
   "ingredients": ["1 inch ginger root, minced", "1/2 lemon, juiced", "1/2 teaspoon manuka honey"],
   "directions": ["Place all ingredients in a mug and fill with warm water (not too hot so you keep the beneficial honey compounds in tact)",
   "Steep for 5-10 minutes", "Drink and enjoy"]
}
```

Response:
```json
{
   "id": 1
}
```

**Example 2**: Response for the `GET /api/recipe/1` request
```json
{
   "name": "Warming Ginger Tea",
   "description": "Ginger tea is a warming drink for cool weather, ...",
   "ingredients": ["1 inch ginger root, minced", "1/2 lemon, juiced", "1/2 teaspoon manuka honey"],
   "directions": ["Place all ingredients in a mug and fill with warm water (not too hot so you keep the beneficial honey compounds in tact)",
   "Steep for 5-10 minutes", "Drink and enjoy"]
}
```

**Example 3**:

`DELETE /api/recipe/1` request

Status code: `204 (No Content)`

`DELETE /api/recipe/1` request

Status code: `404 (Not found)`

**Example 4**:

`GET /api/recipe/1` request

Status code: `404 (Not found)`

<hr/>

### 4: Sort & update
#### 4.1 Description
In this stage, we continue with improving our application. It would be good to retrieve all recipes related to a category (beverages, salads, desserts, and so on), to search for a recipe by name, to update a recipe, or to find out when a recipe was uploaded or updated. To do that, you need two additional fields: `category` and `date`. One field is a recipe category, the other field stores the date. You also need to add two new endpoints. One endpoint will update recipes, the other receives the query parameters that will allow searching for recipes by a category or name.

#### 4.2 Objectives
Don't forget to keep the functionality from the previous stages. This is what your program can do:

- `POST /api/recipe/new` receives a recipe as a JSON object and returns a JSON object with one `id` field;
- `GET /api/recipe/{id}` returns a recipe with a specified `id` as a JSON object;
- `DELETE /api/recipe/{id}` deletes a recipe with a specified `id`.

In this stage, the recipe structure should contain two new fields:

- `category` represents a category of a recipe. The field has the same restrictions as `name` and `description`. It shouldn't be blank;
- `date` stores the date when the recipe has been added (or the last update). You can use any date/time format, for example `2021-09-05T18:34:48.227624` (the default `LocalDateTime` format), but the field should have at least 8 characters.

Also, the service should support the following endpoints:

- `PUT /api/recipe/{id}` receives a recipe as a JSON object and updates a recipe with a specified `id`. Also, update the `date` field too. The server should return the `204 (No Content)` status code. If a recipe with a specified `id` does not exist, the server should return `404 (Not found)`. The server should respond with `400 (Bad Request)` if a recipe doesn't follow the restrictions indicated above (all fields are required, string fields can't be blank, arrays should have at least one item);
- `GET /api/recipe/search` takes one of the two mutually exclusive query parameters:
  - `category` – if this parameter is specified, it returns a JSON array of all recipes of the specified category. Search is case-insensitive, sort the recipes by date (newer first);
  - `name` – if this parameter is specified, it returns a JSON array of all recipes with the names that **contain** the specified parameter. Search is case-insensitive, sort the recipes by date (newer first).

  If no recipes are found, the program should return an empty JSON array. If 0 parameters were passed, or more than 1, the server should return `400 (Bad Request)`. The same response should follow if the specified parameters are not valid. If everything is correct, it should return `200 (Ok)`.

There is a couple of ways to do that. Check the examples below for details. If you need more theory on how to get data from a database or how to process query parameters, take a look at [Query Methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods) paragraph in the Official Documentation (check the table), or the `@RequestParam` [annotation](https://www.baeldung.com/spring-request-param).

#### 4.3 Examples
**Example 1**: `POST /api/recipe/new` request
```json
{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves",
      "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}
```

Response:
```json
{
   "id": 1
}
```

Further `GET /api/recipe/1` response:
```json
{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "date": "2020-01-02T12:11:25.034734",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves",
      "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}
```

Tip: The date field is present in the response only.

**Example 2**: `PUT /api/recipe/1` request
```json
{
   "name": "Warming Ginger Tea",
   "category": "beverage",
   "description": "Ginger tea is a warming drink for cool weather, ...",
   "ingredients": ["1 inch ginger root, minced", "1/2 lemon, juiced", "1/2 teaspoon manuka honey"],
   "directions": ["Place all ingredients in a mug and fill with warm water (not too hot so you keep the beneficial honey compounds in tact)",
      "Steep for 5-10 minutes", "Drink and enjoy"]
}
```

Further response for the `GET /api/recipe/1` request:
```json
{
   "name": "Warming Ginger Tea",
   "category": "beverage",
   "date": "2021-04-06T14:10:54.009725",
   "description": "Ginger tea is a warming drink for cool weather, ...",
   "ingredients": ["1 inch ginger root, minced", "1/2 lemon, juiced", "1/2 teaspoon manuka honey"],
   "directions": ["Place all ingredients in a mug and fill with warm water (not too hot so you keep the beneficial honey compounds in tact)",
      "Steep for 5-10 minutes", "Drink and enjoy"]
}
```

**Example 3**: A database with several recipes
```json
{
   "name": "Iced Tea Without Sugar",
   "category": "beverage",
   "date": "2019-07-06T17:12:32.546987",
   ....
},
{
   "name": "vegan avocado ice cream",
   "category": "DESSERT",
   "date": "2020-01-06T13:10:53.011342",
   ....
},
{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "date": "2021-09-06T14:11:51.006787",
   ....
},
{
   "name": "Vegan Chocolate Ice Cream",
   "category": "dessert",
   "date": "2021-04-06T14:10:54.009345",
   ....
},
{
   "name": "warming ginger tea",
   "category": "beverage",
   "date": "2020-08-06T14:11:42.456321",
   ....
}
```

Response for the `GET /api/recipe/search/?category=dessert` request:
```json
[
   {
      "name": "Vegan Chocolate Ice Cream",
      "category": "dessert",
      "date": "2021-04-06T14:10:54.009345",
      ....
   },
   {
      "name": "vegan avocado ice cream",
      "category": "DESSERT",
      "date": "2020-01-06T13:10:53.011342",
      ....
   },
]
```

Response for the `GET /api/recipe/search/?name=tea` request:
```json
[
   {
      "name": "Fresh Mint Tea",
      "category": "beverage",
      "date": "2021-09-06T14:11:51.006787",
      ....
   },
   {
      "name": "warming ginger tea",
      "category": "beverage",
      "date": "2020-08-06T14:11:42.456321",
      ....
   },
   {
      "name": "Iced Tea Without Sugar",
      "category": "beverage",
      "date": "2019-07-06T17:12:32.546987",
      ....
   },
]
```

Search is case-insensitive, the recipes are sorted by date.

<hr/>

### 5: More chefs to the table
#### 5.1 Description
Imagine a service that supports the registration process, can handle a lot of users, and each of them can add their own recipes. Also, a user can update or delete only their recipes but can view recipes added by other users. In this stage, you will implement all this functionality with Spring Boot Security.

The stage is divided into 3 steps. In the first step, you need to add an endpoint responsible for the user registration. The endpoint receives 2 fields: `email` and `password`. The second step is to enable Spring Security and configure the access restrictions – only the registered users with the correct login and password should have the rights to use the service. After that, restrict the deletion and updating to the recipe author only.

#### 5.2 Objectives
The service should contain all features from the previous stages. To complete the project, you need to add the following functionality:

- New endpoint `POST /api/register` receives a JSON object with two fields: `email` (string), and `password` (string). If a user with a specified email does not exist, the program saves (registers) the user in a database and responds with `200 (Ok)`. If a user is already in the database, respond with the `400 (Bad Request)` status code. Both fields are **required** and must be **valid**: `email` should contain `@` and . symbols, `password` should contain at least 8 characters and shouldn't be blank. If the fields do not meet these restrictions, the service should respond with `400 (Bad Request)`. Also, do not forget to use an encoder before storing a password in a database. `BCryptPasswordEncoder` is a good choice.
- Include the Spring Boot Security dependency and configure access to the endpoints – all implemented endpoints (except `/api/register`) should be available only to the registered and then authenticated and authorized via HTTP Basic auth users. Otherwise, the server should respond with the `401 (Unauthorized)` status code.
- Add additional restrictions – only an author of a recipe can delete or update a recipe. If a user is not the author of a recipe, but they try to carry out the actions mentioned above, the service should respond with the `403 (Forbidden)` status code.

> For testing purposes, `POST/actuator/shutdown` should be available without authentication.

Tip: If you use Postman or any similar program for testing and receive `403 (Forbidden)`, try to disable **CSRF** (Cross-Site Request Forgery) protection. You can disable this type of protection by calling the following methods – `.csrf(csrf -> csrf.disable())` on the `HttpSecurity` instance injected in the method where you build a `SecurityFilterChain` object.

If you use the H2 console, you need to unblock it by disabling **CSRF** and **X-Frame-Options** that prevents clickjacking attacks, by calling the following methods: .csrf(csrf -> `csrf.disable()).headers(headers -> headers.frameOptions().disable())` on the `HttpSecurity` instance. Also, make sure that Spring Security does not block the H2 console URLs.

#### 5.3 Examples
**Example 1**: `POST /api/recipe/new` request without authentication
```json
{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves",
      "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}
```

Status code: `401 (Unauthorized)`

**Example 2**: `POST /api/register` request without authentication
```json
{
   "email": "Cook_Programmer@somewhere.com",
   "password": "RecipeInBinary"
}
```

Status code: `200 (Ok)`

Further `POST /api/recipe/new` request with basic authentication; email (login): Cook_Programmer@somewhere.com, and password: RecipeInBinary
```json
{
   "name": "Mint Tea",
   "category": "beverage",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves",
      "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}
```

Response:
```json
{
   "id": 1
}
```

Further `PUT /api/recipe/1` request with basic authentication; email (login): Cook_Programmer@somewhere.com, password: RecipeInBinary
```json
{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves",
      "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}
```

Status code: `204 (No Content)`

Further `GET /api/recipe/1` request with basic authentication; email (login): Cook_Programmer@somewhere.com, password: RecipeInBinary

Response:
```json
{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "date": "2020-01-02T12:11:25.034734",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves",
      "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}
```

**Example 3**: `POST /api/register` request without authentication
```json
{
   "email": "CamelCaseRecipe@somewhere.com",
   "password": "C00k1es."
}
```

Status code: `200 (Ok)`

Further response for the `GET /api/recipe/1` request with basic authentication; email (login): CamelCaseRecipe@somewhere.com, password: C00k1es.
```json
{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "date": "2020-01-02T12:11:25.034734",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves",
      "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}
```

Further `PUT /api/recipe/1` request with basic authentication; email (login): CamelCaseRecipe@somewhere.com, password: C00k1es.
```json
{
   "name": "Warming Ginger Tea",
   "category": "beverage",
   "description": "Ginger tea is a warming drink for cool weather, ...",
   "ingredients": ["1 inch ginger root, minced", "1/2 lemon, juiced", "1/2 teaspoon manuka honey"],
   "directions": ["Place all ingredients in a mug and fill with warm water (not too hot so you keep the beneficial honey compounds in tact)",
      "Steep for 5-10 minutes", "Drink and enjoy"]
}
```

Status code: `403 (Forbidden)`

Further `DELETE /api/recipe/1` request with basic authentication; email (login): CamelCaseRecipe@somewhere.com, password: C00k1es.

Status code: `403 (Forbidden)`

<hr/>

[<<](../README.md)
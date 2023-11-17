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
<<<<<<< HEAD
   "directions": ["Place all ingredients in a mug and fill with warm water\n (not too hot so you keep the beneficial honey compounds in tact)", "Steep for 5-10 minutes", "Drink and enjoy"]
=======
   "directions": ["Place all ingredients in a mug and fill with warm water (not too hot so you keep the beneficial honey compounds in tact)",
   "Steep for 5-10 minutes", "Drink and enjoy"]
>>>>>>> recipe3
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
<<<<<<< HEAD
   "directions": ["Place all ingredients in a mug and fill with warm water (not too hot so you keep the beneficial honey compounds in tact)", "Steep for 5-10 minutes", "Drink and enjoy"]
=======
   "directions": ["Place all ingredients in a mug and fill with warm water (not too hot so you keep the beneficial honey compounds in tact)",
   "Steep for 5-10 minutes", "Drink and enjoy"]
>>>>>>> recipe3
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

<!-- ### 4:  -->
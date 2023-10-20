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

<!-- next stage -->
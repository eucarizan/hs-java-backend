# Coffee Machine Simulator with Java

- [Coffee Machine Simulator with Java](#coffee-machine-simulator-with-java)
  - [Learning outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Making coffee](#1-making-coffee)
      - [1.1 Description](#11-description)
      - [1.2 Objective](#12-objective)
      - [1.3 Example](#13-example)
    - [2: Ingredient calculator](#2-ingredient-calculator)
      - [2.1 Description](#21-description)
      - [2.2 Objectives](#22-objectives)
      - [2.3 Examples](#23-examples)
  - [Tags](#tags)
  - [Code](#code)

## Learning outcomes
Program a virtual barista to get a taste of Java. You'll create a functional program and gain experience in working on complex coding tasks.

## About
What can be better than a cup of coffee during a break? A coffee that you don’t have to make yourself. It’s enough to press a couple of buttons on the machine and you get a cup of energy; but first, we should teach the machine how to do it.

In this project, you'll program a coffee machine simulator using Java. The machine works with typical products: coffee, milk, sugar, and plastic cups; if it runs out of something, it shows a notification. You can get three types of coffee: espresso, cappuccino, and latte. Since nothing’s for free, it also collects the money.

This project allows you to better understand the basic OOP, its main concepts such as classes, class methods and attributes, and get a taste of Java. Practice working with methods, challenge yourself with loops and conditions, and get more confident with OOP.

## Stages
### 1: Making coffee
#### 1.1 Description
Let's start with a program that makes you a coffee – virtual coffee, of course. In this project, you will implement functionality that simulates a real coffee machine. It can run out of ingredients, such as milk or coffee beans, it can offer you various types of coffee, and, finally, it will take money for the prepared drink.

#### 1.2 Objective
The first version of the program just makes you a coffee. It should print to the standard output what it is doing as it makes the drink.

#### 1.3 Example
Take a look at the sample output below and print all the following lines.

Output:
```
Starting to make a coffee
Grinding coffee beans
Boiling water
Mixing boiled water with crushed coffee beans
Pouring coffee into the cup
Pouring some milk into the cup
Coffee is ready!
```

<hr/>

### 2: Ingredient calculator
#### 2.1 Description
Now let's consider a case where you need a lot of coffee. Maybe you're hosting a party with a lot of guests! In these circumstances, it's better to make preparations in advance.

So, we will ask a user to enter the desired amount of coffee, in cups. Given this, you can adjust the program by calculating how much water, coffee, and milk are necessary to make the specified amount of coffee.

Of course, all this coffee is not needed `right` now, so at this stage, the coffee machine doesn't actually make any coffee.

#### 2.2 Objectives
Let's break the task into several steps:

1. First, read the numbers of coffee drinks from the input.
2. Figure out how much of each ingredient the machine will need. Note that one cup of coffee made on this coffee machine contains *200 ml* of water, *50 ml* of milk, and *15 g* of coffee beans.
3. Output the required ingredient amounts back to the user.

#### 2.3 Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

**Example 1**: *a dialogue with a user might look like this*
```
Write how many cups of coffee you will need:
> 25
For 25 cups of coffee you will need:
5000 ml of water
1250 ml of milk
375 g of coffee beans
```

**Example 2**: *here is another dialogue*
```
Write how many cups of coffee you will need:
> 125
For 125 cups of coffee you will need:
25000 ml of water
6250 ml of milk
1875 g of coffee beans
```

<hr/>

## Tags
`strings` `characters` `printing data` `types and variables` `integer types and operations` `comments` `naming variables`
`reading user's input with scanner` `arithmetic operations` `basic terms: jvm, jre, jdk` `write, compile, and run`
`increment and decrement` `command line overview` `parameters and options` `coding style conventions`

## Code
- [solution class](./src/main/java/CoffeeMachine.java)
- [unit tests](./src/test/java/CoffeeMachineTest.java)

[<<](../README.md)
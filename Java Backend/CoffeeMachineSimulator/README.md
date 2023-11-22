# CoffeeMachine Machine Simulator with Java

- [CoffeeMachine Machine Simulator with Java](#coffee-machine-simulator-with-java)
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
    - [3: Estimate the number of servings](#3-estimate-the-number-of-servings)
      - [3.1 Description](#31-description)
      - [3.2 Objectives](#32-objectives)
      - [3.3 Examples](#33-examples)
    - [4: Buy, fill, take!](#4-buy-fill-take)
      - [4.1 Description](#41-description)
      - [4.2 Objectives](#42-objectives)
      - [4.3 Examples](#43-examples)
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
CoffeeMachine is ready!
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

### 3: Estimate the number of servings
#### 3.1 Description
A real coffee machine doesn't have an infinite supply of water, milk, or coffee beans. And if you input a really big number, it's almost certain that a real coffee machine wouldn't have the supplies needed to make all that coffee for you.

In this stage, you need to improve the previous program. Now you will check amounts of water, milk, and coffee beans available in your coffee machine at the moment.

#### 3.2 Objectives
Write a program that does the following:

1. It requests the amounts of water, milk, and coffee beans available at the moment, and then asks for the number of cups a user needs.
2. If the coffee machine has enough supplies to make the specified amount of coffee, the program should print `"Yes, I can make that amount of coffee"`.
3. If the coffee machine can make more than that, the program should output `"Yes, I can make that amount of coffee (and even N more than that)"`, where *N* is the number of additional cups of coffee that the coffee machine can make.
4. If the amount of given resources is not enough to make the specified amount of coffee, the program should output `"No, I can make only N cup(s) of coffee"`.

Like in the previous stage, the coffee machine needs *200 ml* of water, *50 ml* of milk, and *15 g* of coffee beans to make one cup of coffee.

#### 3.3 Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

**Example 1:**
```
Write how many ml of water the coffee machine has:
> 300
Write how many ml of milk the coffee machine has:
> 65
Write how many grams of coffee beans the coffee machine has:
> 100
Write how many cups of coffee you will need:
> 1
Yes, I can make that amount of coffee
```

**Example 2:**
```
Write how many ml of water the coffee machine has:
> 500
Write how many ml of milk the coffee machine has:
> 250
Write how many grams of coffee beans the coffee machine has:
> 200
Write how many cups of coffee you will need:
> 10
No, I can make only 2 cup(s) of coffee
```

**Example 3:**
```
Write how many ml of water the coffee machine has:
> 1550
Write how many ml of milk the coffee machine has:
> 299
Write how many grams of coffee beans the coffee machine has:
> 300
Write how many cups of coffee you will need:
> 3
Yes, I can make that amount of coffee (and even 2 more than that)
```

**Example 4:**
```
Write how many ml of water the coffee machine has:
> 0
Write how many ml of milk the coffee machine has:
> 0
Write how many grams of coffee beans the coffee machine has:
> 0
Write how many cups of coffee you will need:
> 1
No, I can make only 0 cup(s) of coffee
```

**Example 5:**
```
Write how many ml of water the coffee machine has:
> 0
Write how many ml of milk the coffee machine has:
> 0
Write how many grams of coffee beans the coffee machine has:
> 0
Write how many cups of coffee you will need:
> 0
Yes, I can make that amount of coffee
```

**Example 6:**
```
Write how many ml of water the coffee machine has:
> 200
Write how many ml of milk the coffee machine has:
> 50
Write how many grams of coffee beans the coffee machine has:
> 15
Write how many cups of coffee you will need:
> 0
Yes, I can make that amount of coffee (and even 1 more than that)
```

<hr/>

### 4: Buy, fill, take!
#### 4.1 Description
Let's simulate an actual coffee machine! What do we need for that? This coffee machine will have a limited supply of water, milk, coffee beans, and disposable cups. Also, it will calculate how much money it gets for selling coffee.

There are several options for the coffee machine we want you to implement: first, it should sell coffee. It can make different types of coffee: espresso, latte, and cappuccino. Of course, each variety requires a different amount of supplies, however, in any case, you will need only one disposable cup for a drink. Second, the coffee machine must get replenished by a special worker. Third, another special worker should be able to take out money from the coffee machine.

#### 4.2 Objectives
Write a program that offers to buy one cup of coffee or to fill the supplies or to take its money out. Note that the program is supposed to do one of the mentioned actions at a time. It should also calculate the amounts of remaining ingredients and how much money is left. Display the quantity of supplies before and after purchase.

1. First, your program reads one option from the standard input, which can be `"buy"`, `"fill"`, `"take"`. If a user wants to buy some coffee, the input is `"buy"`. If a special worker thinks that it is time to fill out all the supplies for the coffee machine, the input line will be `"fill"`. If another special worker decides that it is time to take out the money from the coffee machine, you'll get the input `"take"`.
2. If the user writes `"buy"` then they must choose one of three types of coffee that the coffee machine can make: espresso, latte, or cappuccino.
   - For one espresso, the coffee machine needs *250 ml* of water and *16 g* of coffee beans. It costs *$4*.
   - For a latte, the coffee machine needs *350 ml* of water, *75 ml* of milk, and *20 g* of coffee beans. It costs *$7*.
   - And for a cappuccino, the coffee machine needs *200 ml* of water, *100 ml* of milk, and *12 g* of coffee beans. It costs *$6*.
3. If the user writes `"fill"`, the program should ask them how much water, milk, coffee and how many disposable cups they want to add into the coffee machine.
4. If the user writes `"take"` the program should give all the money that it earned from selling coffee.

At the moment, the coffee machine has `$550`, `400 ml` of water, `540 ml` of milk, `120 g` of coffee beans, and `9` disposable cups.

To sum up, your program should print the coffee machine's state, process one query from the user, as well as print the coffee machine's state after that. Try to use functions for implementing every action that the coffee machine can do.

#### 4.3 Examples
An espresso should be number *1* in the list, a latte number *2*, and a cappuccino number *3*.
Options are named as `"buy"`, `"fill"`, `"take"`.

The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

**Example 1:**
```
The coffee machine has:
400 ml of water
540 ml of milk
120 g of coffee beans
9 disposable cups
$550 of money

Write action (buy, fill, take):
> buy
What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:
> 3

The coffee machine has:
200 ml of water
440 ml of milk
108 g of coffee beans
8 disposable cups
$556 of money
```

**Example 2:**
```
The coffee machine has:
400 ml of water
540 ml of milk
120 g of coffee beans
9 disposable cups
$550 of money

Write action (buy, fill, take):
> fill
Write how many ml of water you want to add:
> 2000
Write how many ml of milk you want to add:
> 500
Write how many grams of coffee beans you want to add:
> 100
Write how many disposable cups you want to add:
> 10

The coffee machine has:
2400 ml of water
1040 ml of milk
220 g of coffee beans
19 disposable cups
$550 of money
```

Example 3:
```
The coffee machine has:
400 ml of water
540 ml of milk
120 g of coffee beans
9 disposable cups
$550 of money

Write action (buy, fill, take):
> take
I gave you $550

The coffee machine has:
400 ml of water
540 ml of milk
120 g of coffee beans
9 disposable cups
$0 of money
```

<hr/>

## Tags
`strings` `characters` `printing data` `types and variables` `integer types and operations` `comments` `naming variables`
`reading user's input with scanner` `arithmetic operations` `basic terms: jvm, jre, jdk` `write, compile, and run`
`increment and decrement` `command line overview` `parameters and options` `coding style conventions` `conditional statement`
`boolean` `relational operators` `break` `continue` `switch` `for-loop` `while and do-while loops` `ternary operator`
`intellij idea`

## Code
- [solution class](./src/main/java/CoffeeMachine.java)
- [unit tests](./src/test/java/CoffeeMachineTest.java)

[<<](../README.md)
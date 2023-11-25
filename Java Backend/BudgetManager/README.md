# Budget Manager

- [Budget Manager](#budget-manager)
  - [Learning outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Count my money](#1-count-my-money)
      - [1.1 Description](#11-description)
      - [1.2 Example](#12-example)
  - [Code](#code)

## Learning outcomes
You will create a very applicable product, and in the meanwhile also get acquainted with the basic concepts of programming in Java. You will deal with the widest variety of tools: work with strings, perform mathematical calculations, sort the data, and work with files.

## About
Not to sound overly serious, but it’s very important to manage your budget. This implies analyzing your expenses and estimating the income, which sometimes may be difficult to do yourself. Luckily, technology is there to assist: you can create your own personal budget manager program that counts the ins and outs and helps control the finances.

## Stages
### 1: Count my money
#### 1.1 Description
First, let’s implement the counting of your purchases. It’s much easier to analyze when your expenses are presented as a list. Read data from the console and at the end show the list of all purchases and its total amount.
It should be displayed as follows: `Total: $23.00`

Your program should process every line the user inputs. To end the input, the user should type [End-of-file](https://en.wikipedia.org/wiki/End-of-file) symbol that tells your operating system that no more input will be provided. It's `Ctrl+D` on Linux and Mac and `Ctrl+Z` on Windows. Don't be scared: you don’t have to implement it yourself, this is a special built-in hot-key that gives the command to stop input. See for yourself!

#### 1.2 Example
The greater-than symbol followed by a space (`> `) represents the user input. Notice that it's not part of the input.
```
> Almond 250gm $35.43
> LEGO DUPLO Town Farm Animals $10.10
> Sensodyne Pronamel Toothpaste $19.74
> Hershey's milk chocolate bars $8.54
> Gildan LT $8.61
Almond 250gm $35.43
LEGO DUPLO Town Farm Animals $10.10
Sensodyne Pronamel Toothpaste $19.74
Hershey's milk chocolate bars $8.54
Gildan LT $8.61

Total: $82.42
```

<hr/>

## Code
- [solution class](./src/main/java/Solution.java)
- [unit tests](./src/test/java/SomeParamTest.java)
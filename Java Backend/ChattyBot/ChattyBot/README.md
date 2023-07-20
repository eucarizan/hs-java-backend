# Simple Chatty Bot (Java)

- [Simple Chatty Bot (Java)](#simple-chatty-bot-java)
  - [Learning Outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Chatty Bot welcomes you](#1-chatty-bot-welcomes-you)
      - [Description](#description)
      - [Objective](#objective)
      - [Example](#example)
    - [2: Print your name](#2-print-your-name)
      - [Description](#description-1)
      - [Objective](#objective-1)
      - [Example](#example-1)

## Learning Outcomes
Get to know the basic syntax of Java and write a simple program using variables, conditions, loops, and methods.

## About
Here, at the beginning of your programmer’s path, creating a simple console chat bot will do wonders to guide you through the basics of coding. During this journey, you will also play some word and number games that you are going to implement on your own. Pack up and let’s hit the road, my friend!

## Stages
### 1: Chatty Bot welcomes you
#### Description
Digital personal assistants help people to drive cars, plan their day, buy something online. In a sense, they are simplified versions of artificial intelligence with whom you can talk.

In this project, you will develop step by step a simple bot that will help you study programming.

#### Objective
For the first stage, you will write a bot who displays a greeting, its name, and the date of its creation. First impressions count!

Your program should print the following lines:
```java
Hello! My name is {botName}.
I was created in {birthYear}.
```

Instead of `{botName}`, print any name you choose and replace `{birthYear}` with the current year (four digits).

#### Example
Output
```java
Hello! My name is Aid.
I was created in 2020.
```

You can change the text if you want but print exactly two lines.

Next, we will use Aid and 2020 as your bot's name and its birth year, but you can change it if you need to.

### 2: Print your name
#### Description
The greeting part is great, but chatbots are also supposed to interact with a user. It's time to implement this functionality.

#### Objective
In this stage, you will introduce yourself to the bot so that it can greet you by your name.

Your program should print the following lines:
```java
Hello! My name is Aid.
I was created in 2020.
Please, remind me your name.
What a great name you have, {yourName}!
```

You may change the name and the creation year of your bot if you want.

Instead of `{yourName}`, the bot must print your name entered from the standard input.

#### Example
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

**Example 1:** _a dialogue with the bot_

```java
Hello! My name is Aid.
I was created in 2020.
Please, remind me your name.
> Max
What a great name you have, Max!
```

Use the provided template to simplify your work. You can change the text but not the number of printed lines.
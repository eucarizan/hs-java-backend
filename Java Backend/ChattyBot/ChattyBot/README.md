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
    - [3: Guess the age](#3-guess-the-age)
      - [Description](#description-2)
      - [Objective](#objective-2)
      - [Example](#example-2)
    - [4: Learning numbers](#4-learning-numbers)
      - [Description](#description-3)
      - [Objective](#objective-3)
      - [Example](#example-3)

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
```console
Hello! My name is {botName}.
I was created in {birthYear}.
```

Instead of `{botName}`, print any name you choose and replace `{birthYear}` with the current year (four digits).

#### Example
Output
```console
Hello! My name is Aid.
I was created in 2020.
```

Next, we will use Aid and 2020 as your bot's name and its birth year, but you can change it if you need to.

### 2: Print your name
#### Description
The greeting part is great, but chatbots are also supposed to interact with a user. It's time to implement this functionality.

#### Objective
In this stage, you will introduce yourself to the bot so that it can greet you by your name.

Your program should print the following lines:
```console
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

```console
Hello! My name is Aid.
I was created in 2020.
Please, remind me your name.
> Max
What a great name you have, Max!
```

### 3: Guess the age
#### Description
Keep improving your bot by developing new skills for it. We suggest a simple guessing game that will predict the age of a user.

It's based on a simple math trick. First, take a look at this formula:
```
age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
```

The numbers `remainder3`, `remainder5`, and `remainder7` are the remainders of the division of `age` by 3, 5, and 7 respectively.

It turns out that for each number ranging from _0_ to _104_, the calculation will result in the number itself.
This perfectly fits the ordinary age range, doesn't it? Ask the user for the remainders and use them to guess the age!

#### Objective
In this stage, you will introduce yourself to the bot. It will greet you by your name and then try to guess your age using arithmetic operations.

Your program should print the following lines:
```console
Hello! My name is Aid.
I was created in 2020.
Please, remind me your name.
What a great name you have, Max!
Let me guess your age.
Enter remainders of dividing your age by 3, 5 and 7.
Your age is {yourAge}; that's a good time to start programming!
Read three numbers from the standard input. Assume that all the numbers will be given on separate lines.
```
Instead of `{yourAge}`, the bot will print the age determined according to the special formula discussed above.

#### Example
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

**Example 1:** _a dialogue with the bot_
```console
Hello! My name is Aid.
I was created in 2020.
Please, remind me your name.
> Max
What a great name you have, Max!
Let me guess your age.
Enter remainders of dividing your age by 3, 5 and 7.
> 1
> 2
> 1
Your age is 22; that's a good time to start programming!
```

### 4: Learning numbers
#### Description
Now you will teach your bot to count. It's going to become an expert in numbers!

#### Objective
In this stage, you will program the bot to count from 0 to any positive number users enter.

#### Example
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

**Example 1:** _a dialogue with the bot_
```console
Hello! My name is Aid.
I was created in 2020.
Please, remind me your name.
> Max
What a great name you have, Max!
Let me guess your age.
Enter remainders of dividing your age by 3, 5 and 7.
> 1
> 2
> 1
Your age is 22; that's a good time to start programming!
Now I will prove to you that I can count to any number you want.
> 5
0!
1!
2!
3!
4!
5!
Completed, have a nice day!
```

**Note:** each number starts with a new line, and after a number, the bot should print the exclamation mark.


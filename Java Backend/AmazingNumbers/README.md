# Amazing Numbers

- [Amazing Numbers](#amazing-numbers)
  - [Learning outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Buzz numbers](#1-buzz-numbers)
      - [1.1 Description](#11-description)
      - [1.2 Objectives](#12-objectives)
      - [1.3 Examples](#13-examples)

## Learning outcomes
The project covers basic operations on integers, as well as with collections. Make a program that indicates the properties of the numbers taken from the input.

## About
We use numbers every day. But do you know how many different properties they have? Let's take a look at some of the amazing properties of numbers. After completing this project, you will write a program that knows how to determine whether a number is Palindromic or Gapful, or how to distinguish Spy numbers from others. Numbers can be fascinating!

## Stages
### 1: Buzz numbers
#### 1.1 Description
Integers can be even or odd. All numbers that end with 0, 2, 4, 6, or 8 are even; the rest are odd. However, numbers have many other properties, you will learn about some of them in this project.

First, let's talk about **Buzz numbers**. They are numbers that are either divisible by 7 or end with 7. For example, the number 14 is a buzz number, since it is divisible by 7 without a remainder; the number 17 ends with 7, so it is also a buzz number. However, the number 75 is not a Buzz number, since it is neither divisible by 7 nor does it end with 7. The number 7 is a Buzz number too.

Your task at this stage is to write a program that prints the natural number parity and determines whether this number is a Buzz. The program should print why this number is a Buzz number.

Do you know how to determine whether a number is divisible by 7 or not? We have a great tip:

1. Remove the last digit;
2. Multiply the removed digit by 2 and subtract it from the remaining number.
3. If the result of the subtraction can be divided by 7, then the initial number is divisible by 7. You can apply the whole sequence multiple times until you get a relatively small/easy-to-interpret subtraction result.

For example, take 196. We remove the last digit and get 19. We subtract 12 (the removed digit multiplied by 2) to get 7. Since the last left digit is 7, the number is multiple of 7. So 196 is a Buzz number!

You can use any solution you want, the tests won't check it.

#### 1.2 Objectives
Your program should check whether the given natural number is a buzz number.

1. Ask a user to enter a natural number.
2. If the number is not natural, print an error message.
3. Calculate and print the parity of the number.
4. Check whether is the number is a Buzz number and print the explanation.
5. Finish the program after printing the message.

Natural numbers are whole numbers starting from 1.

Explanations:
```console
... is neither divisible by 7 nor does it end with 7
```
```console
... is divisible by 7
```
```console
... ends with 7
```
```console
... is divisible by 7 and ends with 7
```

Error message:
```console
This number is not natural!
```

#### 1.3 Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

**Example 1:**
```console
Enter a natural number:
> 13
This number is Odd.
It is not a Buzz number.
Explanation:
13 is neither divisible by 7 nor does it end with 7.
```

**Example 2:**
```console
Enter a natural number:
> 14
This number is Even.
It is a Buzz number.
Explanation:
14 is divisible by 7.
```

**Example 3:**
```console
Enter a natural number:
> 17
This number is Odd.
It is a Buzz number.
Explanation:
17 ends with 7.
```

**Example 4:**
```console
Enter a natural number:
> 7
This number is Odd.
It is a Buzz number.
Explanation:
7 is divisible by 7 and ends with 7.
```

**Example 5:**
```console
Enter a natural number:
-76
This number is not natural!
```


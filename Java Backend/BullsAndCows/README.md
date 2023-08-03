# Bulls and Cows

- [Bulls and Cows](#bulls-and-cows)
  - [Learning outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Game log](#1-game-log)
      - [1.1 Description](#11-description)
      - [1.2 Objectives](#12-objectives)

## Learning outcomes
Learn how to use integer arithmetic, generate random numbers, store data in data structures, and handle errors.

## About
Write your own advanced version of the classic code breaking game "Bulls and Cows". Start with recreating the original version of the game and then take it to a new level.

## Stages
### 1: Game log
#### 1.1 Description
Let's start by reminding ourselves how the game goes. There are two players: the first writes a secret 4-digit code using different digits, and the second has to guess it. At each turn, the second player writes a 4-digit number that they think might be the correct answer. Then, the first player grades that answer using bulls and cows as a notation. If a digit in the given answer matches a digit and its position in the code, it's called a "bull." If a given digit appears in the code but its position doesn't match, then it's called a "cow." The first player reveals how many bulls and cows there are. The information is general; in other words, it isn't bound to any particular digit. For example:

The code is 4931.
The answer is 1234.
The grade is 1 bull and 2 cows.

Here, 3 is a bull, 1 and 4 are cows. If all the digits are bulls, the secret code has been guessed and the game ends. If not, the game continues and the second player tries again.

This may sound rather complicated, but don't worry, we will take it very gradually. In this stage, you will not even have to implement the gameplay: all you need to do now is output the text that could be in the game. In other words, you don't have to worry about handling any requests or processing data: your goal is to display an example text of the game.

#### 1.2 Objectives
In this stage, your program should

- Print a predefined game log that contains at least two turns.
- The output to be graded is a 4-digit code consisting of unique digits.
- The last line of your output contains a secret number.

**Example 1.3.1**
```console
The secret code is prepared: ****.

Turn 1. Answer:
1234
Grade: 1 cow.

Turn 2. Answer:
5678
Grade: 1 cow.

Turn 3. Answer:
9012
Grade: 1 bull and 1 cow.

Turn 4. Answer:
9087
Grade: 1 bull and 1 cow.

Turn 5. Answer:
1087
Grade: 1 cow.

Turn 6. Answer:
9205
Grade: 3 bulls.

Turn 7. Answer:
9305
Grade: 4 bulls.
Congrats! The secret code is 9305.
```

**Example 1.3.2**
```console
The secret code is prepared: ****.

Turn 1. Answer:
1234
Grade: None.

Turn 2. Answer:
9876
Grade: 4 bulls.
Congrats! The secret code is 9876.
```

<!--
#### 1.3 Example
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input. -->
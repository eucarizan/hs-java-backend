# Rock-Paper-Scissors (Java)

- [Rock-Paper-Scissors (Java)](#rock-paper-scissors-java)
  - [Learning Outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Unfair computer](#1-unfair-computer)
      - [1.1 Description](#11-description)
      - [1.2 Objectives](#12-objectives)
      - [1.3 Example](#13-example)
    - [2: Equalizing chances](#2-equalizing-chances)
      - [2.1 Description](#21-description)
      - [2.2 Objectives](#22-objectives)
      - [2.3 Example](#23-example)
    - [3: Endless game](#3-endless-game)
      - [3.1 Description](#31-description)
      - [3.2 Objectives](#32-objectives)
      - [3.3 Example](#33-example)
    - [4: Scoring the game](#4-scoring-the-game)
      - [4.1 Description](#41-description)
      - [4.2 Objectives](#42-objectives)
      - [4.3 Example](#43-example)

## Learning Outcomes
A playable Rock-Paper-Scissors game, with a Player vs. Computer mode. Practice using arrays, the Random class, formatted strings, and algorithms.

## About
If you’ve ever wanted to create games, this project will get you started! In this project, you will code a Rock-Paper-Scissors-Lizard-Spock game, a more advanced version of Rock-Paper-Scissors and play against the computer.

## Stages
### 1: Unfair computer
#### 1.1 Description
Rock paper scissors is a popular hand game. Two players simultaneously form one of three shapes with their hands, and then, depending on the shapes, one player wins — rock beats scissors, paper wins over rock, scissors defeats paper.
The game is well-known for fair win-conditions between equal options.

Let's start with an unfair version! :)

Write a program that reads input that states which option users have chosen. After this, your program must make users lose! That is, your program should always select an option that defeats the one picked by users. Once it finds this option, output the line `Sorry, but the computer chose <option>`, where `<option>` is the name of the option that the program's picked depending on the user's input.
For example, if users enter `rock`, the program should print `Sorry, but the computer chose paper` and so on.

Pay attention to the format of the output. It should follow the one in the example, including capital letters and punctuation. Do not print additional strings.

Just think about it: in this stage, the computer has to win every time.
- if users choose `paper`, the computer chooses `scissors` (the computer wins);
- if users choose `scissors`, the computer chooses `rock` (the computer wins);
- if users choose `rock`, the computer chooses `paper` (the computer wins).

#### 1.2 Objectives
Your program should:
- Take input from the user;
- Find an option that wins over the user's option;
- Output the line: `Sorry, but the computer chose <option>`.

#### 1.3 Example
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

**Example 1.1:**
```console
> scissors
Sorry, but the computer chose rock
```

**Example 1.2:**
```console
> paper
Sorry, but the computer chose scissors
```

### 2: Equalizing chances
#### 2.1 Description
Well, now let's do something more tangible. Nobody wants to play the game where you always lose. We can use the power of the `Random` class to make the game a bit more challenging.

Write a program that reads input from users, chooses a random option, and then says who won: a user or the computer.
There are a few examples below to provide the output for any outcome (`<option>` is the option chosen by your program):

Loss: `Sorry, but the computer chose <option>`;
Draw: `There is a draw (<option>)`;
Win: `Well done. The computer chose <option> and failed`;

#### 2.2 Objectives
Your program should:

- Read the user input that includes an option;
- Choose a random option;
- Compare the options and determine the winner;
- Output one of the lines above depending on the result of the game.

#### 2.3 Example
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

**Example 2.1:**
```console
> rock
Well done. The computer chose scissors and failed
```

**Example 2.2:**
```console
> scissors
There is a draw (scissors)
```

**Example 2.3:**
```console
> paper
Sorry, but the computer chose scissors
```

### 3: Endless game
#### 3.1 Description
We came up with a really cool idea in the previous stage. But the game is really short. Nobody plays a single shot of rock paper scissors. We need to find a way to run the game forever. Not literally, though — let's implement a way to stop your program.

Improve your program so that it will take an unlimited number of inputs until users enter `!exit`. After entering `!exit`, the program should print `Bye!` and terminate. Also, let's try to handle invalid inputs: your program should be ready to handle typos in user input, or when there's a mishmash instead of a normal command. So, if the input doesn't correspond to any known command (an option or `!exit`), your program should output the following line: `Invalid input`.

#### 3.2 Objectives
Your program should:
- Take input from users;
- If the input contains `!exit`, output `Bye!` and stop the game;
- If the input is the name of the option, then pick a random option and output a line with the result of the game in the following format (`<option>` is the name of the option chosen by the program):
  - Loss: `Sorry, but the computer chose <option>`
  - Draw: `There is a draw (<option>)`
  - Win: `Well done. The computer chose <option> and failed`
- If the input corresponds to anything else, output Invalid input;
- Repeat it all over again.

#### 3.3 Example
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

**Example 3.3.1:**
```console
> rock
Well done. The computer chose scissors and failed
> paper
Well done. The computer chose rock and failed
> paper
There is a draw (paper)
> scissors
Sorry, but the computer chose rock
> rokc
Invalid input
> xit!
Invalid input
> !exit
Bye!
```

### 4: Scoring the game
#### 4.1 Description
People love to see their results as they're advancing to their goals. So, let's learn how to show the scoreboard!

When the game starts, users must be able to enter their names. After that, the program should greet users and read a file named _rating.txt_.

> In order to execute the test program correctly, name the file _rating.txt_ and save it in the current directory, without subdirectories. In tests this file will be created, pre-filled with data. Make sure that you read the data correctly when you start the game.

It is the file that contains the current scores for different players. You can see the file format below: lines containing usernames and their scores, divided by a single space:

```
Tim 350
Jane 200
Alex 400
```

Take the current user score from the file and use it as a basis for counting the score during the game. For example, if a user entered `Tim`, then their score at the start of the game is `350`. If a user inputs a name that is not on the list, the program should count the score from `0`.

> No need to write anything to the _rating.txt_ file.

Print the user score with the `!rating` command. For example, if your rating is `0`, then the program should print:
```
Your rating: 0
```

Add `50` points for every draw, `100` for every win, and `0` for losing.

#### 4.2 Objectives
Your program should:
- Output a line `Enter your name:`. Users enter their names on the same line (not the one following the output!);
- Read input with the name and output a new line: `Hello, <name>`
- Read _rating.txt_ and check whether it contains an entry with the current username. If yes, use the score specified in the file as a starting point. If not, start the score from `0`.
- Play the game by the rules defined in the previous stages and read the user input;
- If the input is `!exit`, output `Bye!` and stop the game;
- If the input is the name of the option, then pick a random option and output a line with the result in the following format (`<option>` is the name of the option chosen by the program):
  - Loss: `Sorry, but the computer chose <option>`
  - Draw: `There is a draw (<option>)`
  - Win: `Well done. The computer chose <option> and failed`
- For each draw, add `50` points to the score. For each win, add `100` points. In case a user loses, don't change the score;
- If the input corresponds to anything else, output `Invalid input`;
- Restart the game.

#### 4.3 Example
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

**Example 4.3.1:**
```console
Enter your name: > Tim
Hello, Tim
> !rating
Your rating: 350
> rock
Sorry, but the computer chose paper
> paper
Well done. The computer chose rock and failed
> scissors
There is a draw (scissors)
> !rating
Your rating: 500
> !exit
Bye!
```

**Example 4.3.2:**
```console
Enter your name: > Chuck
Hello, Chuck
> scissors
There is a draw (scissors)
> rock
Well done. The computer chose scissors and failed
> paper
Well done. The computer chose rock and failed
> !rating
Your rating: 250
> !exit
Bye!
```
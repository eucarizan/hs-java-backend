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
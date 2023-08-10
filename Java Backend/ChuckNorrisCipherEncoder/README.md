# Chuck Norris Cipher Encoder (Java)

- [Chuck Norris Cipher Encoder (Java)](#chuck-norris-cipher-encoder-java)
  - [Learning outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Analyze the words](#1-analyze-the-words)
      - [1.1 Description](#11-description)
      - [1.2 Objectives](#12-objectives)
      - [1.3 Examples](#13-examples)
    - [2: The binary world](#2-the-binary-world)
      - [2.1 Description](#21-description)
      - [2.2 Objectives](#22-objectives)
      - [2.3 Examples](#23-examples)

## Learning outcomes
This project will allow us to deal with string and character variables and work with loops and conditional statements. Get familiar with the binary notation and data type conversion. Create an application for the unary representation and decoding of any text.

## About
Secret agents use encryption all the time. You know that everything can be encrypted as different characters. What about encryption that uses only one character and space? This method has a name — the Chuck Norris cipher. In this project, you will create a program that can encrypt any text into a sequence of zeros and spaces and decrypt this sequence into text.

## Stages
### 1: Analyze the words
#### 1.1 Description
To begin with, you will learn how to divide an encrypted message into the characters that it contains. You will need this for further work.

#### 1.2 Objectives
In this stage, your program should:

1. Read a string from a console. The input contains a single line.
2. Output all characters in the string, separated by one spac (including the space characters themselves).

#### 1.3 Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

**Example 1:**
```console
Input string:
> Greetings!

G r e e t i n g s !
```

**Example 2:**
```console
Input string:
> Who am I?

W h o   a m   I ?
```

### 2: The binary world
#### 2.1 Description
In this stage, you'll learn how to convert each character of a string into a binary form. Any ASCII character has a size of 7 bits; in binary, the form is `0` and `1`. For example, the character `A` has a decimal value of `65`. The binary representation is `1000001`. `b` is `98` in decimal or `1100010` in binary. The space character is `32` in decimal value or `0100000` in binary.

In this stage, you will learn to represent characters in binary form.

#### 2.2 Objectives
In this stage, your program should:

1. Read a string from a console. The input contains a single line.
2. Print `The result:` line, followed by each character of input on a separate line, formatted as `<char> = <binary value>`.

Note that the binary representation must be 7-bit, even if the first digits are zeros. The `Integer.toBinaryString()` and `String.format()` methods can help you with that.

#### 2.3 Examples
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

**Example 1:**
```console
Input string:
> One

The result:
O = 1001111
n = 1101110
e = 1100101
```

**Example 2:**
```console
Input string:
> 123

The result:
1 = 0110001
2 = 0110010
3 = 0110011
```

**Example 3:**
```console
Input string:
> Who am I?

The result:
W = 1010111
h = 1101000
o = 1101111
  = 0100000
a = 1100001
m = 1101101
  = 0100000
I = 1001001
? = 0111111
```


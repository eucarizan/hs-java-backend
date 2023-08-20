#  Card name validation and identification

## Description
Write a program that uses regular expressions to check whether the input card number is valid and identifies the card network name.

The input must consist only of numbers. Your program must take a string as an input and print the name of the card network as output, choosing from the set of names specified below, or the message: "Card number does not exist”.

Card networks: Visa, Mastercard, American Express.

- A Visa card starts with 4 and has the length of 16 digits.
- A MasterCard starts with the numbers from 51 to 55, or the numbers 2221 to 2720. All have 16 digits.
- American Express card numbers start with 34 or 37 and have 15 digits.


<!--find and replace
(Sample Input \d:|Sample Output \d:)
```\n**$1**\n```console
-->
## Examples
**Sample Input 1:**
```console
4235 2345 6543 1234
```
**Sample Output 1:**
```console
Visa
```

## Tags
- regular expressions
- string matches
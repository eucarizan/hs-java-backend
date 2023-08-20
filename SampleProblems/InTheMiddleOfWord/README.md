#  In the middle of a word

## Description
The first line of the input contains a sequence of letters.

The second line of the input contains some text.

Your task is to determine whether any of the words from the second line contain this sequence of letters. Count only the words that do not start or end with your search term. If such a word is present in the line, output "YES", otherwise output "NO". The word can contain only the letters of the English alphabet. Ignore the case while searching for matches.

## Examples
**Sample Input 1:**
```console

Gramm
Java is the most popular programming language

```
**Sample Output 1:**
```console
YES
```

**Sample Input 2:**
```console
Press
Regular expressions is hard to read, isnt it?
```

**Sample Output 2:**
```console
YES
```

**Sample Input 3:**
```console
some
Wow! How awesome is that!
```

**Sample Output 3:**
```console
NO
```

## Tags
- regular expressions
- patterns and matcher


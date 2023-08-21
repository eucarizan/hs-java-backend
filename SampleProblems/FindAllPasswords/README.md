# Find all passwords

## Description
Write a program searching for passwords in a given text. It is known that:

- a password consists of digits and/or Latin upper- and lowercase letters in any combination;
- a password always follows the word "**password**" (it can be written in upper- and/or lowercase letters) but can be separated from it by any number of whitespaces and colon `:` characters.

Output all passwords found in the text, each password starting with a new line. If the text does not contain any passwords, output "**No passwords found**." without quotes.

Try to use `Matcher` and `Pattern` to solve it. All the needed modules are already imported.


## Examples
**Sample Input 1:**
```console
My email javacoder@gmail.com with password    SECRET115. Here is my old PASSWORD: PASS.
```

**Sample Output 1:**
```console
SECRET115
PASS
```

**Sample Input 2:**
```console
My email is javacoder@gmail.com.
```

**Sample Output 2:**
```console
No passwords found.
```

## Tags
- regular expressions
- pattern and matcher
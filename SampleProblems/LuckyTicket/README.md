#  The lucky ticket

Paul loves to ride public transport and after receiving a ticket, he immediately checks whether he got a lucky one. A ticket is considered a lucky one if the sum of the first three numbers of this ticket matches the sum of the last three numbers.

However, Paul does not count well in his head. That is why he asks you to write a program which will check the equality of the sums and display "Lucky" if the sums match, and "Regular" if the sums differ.

A string of six digits is provided as input to the program.

You need to print out only the word "**Lucky**" or "**Regular**" with a capital letter (without quotes).

**Tip:** To get the int value that the character actually represents, you can use the `Character.getNumericValue()` method

```java
char charValue = '2';
int intValue = Character.getNumericValue(charValue); // 2
```

This is an incorrect way to get the `int` value:

```java
int intValue = (int) charValue; // 50, which is the ASCII code for character ‘2’
```

## Examples
**Sample Input 1:**
```console
090234
```

**Sample Output 1:**
```console
Lucky
```

**Sample Input 2:**
```console
123456
```

**Sample Output 2:**
```console
Regular
```

## Tags
- basics
- strings
- processing strings
#  Check the clock time

## Description
For a given string you should check whether it shows time in the correct format. The string should consist of two integers separated by the colon. The first integer should be from 00 to 23 and the second integer should be from 00 to 59.

Note that if only one digit in the integer, it should be padded with a leading zero. That is, strings `"5:00"` and `"05:1"` don't show time correctly, but `"05:00"` and `"05:01"` do.

Output "YES" if the given string shows time in the correct format, otherwise output "NO".

<!--find and replace
(Sample Input \d:|Sample Output \d:)
```\n\n**$1**\n```console
-->
## Examples
**Sample Input 1:**
```console
09:00
```

**Sample Output 1:**
```console
YES
```

**Sample Input 2:**
```console
23:59
```

**Sample Output 2:**
```console
YES
```

**Sample Input 3:**
```console
24:00
```

**Sample Output 3:**
```console
NO
```

## Tags
- regular expressions
- string matches
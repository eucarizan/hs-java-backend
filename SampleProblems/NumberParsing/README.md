# Number parsing

## Description
You need to write a regular expression that can match any number.

A number can be positive or negative. If it is negative, then it must start with a '-'. If it is positive, it may start with a '+'. If it doesn't start with either '+' or '-' it is considered positive.

A number representation can't be padded with leading zeroes. For example, `001` is not a valid number (but `0` is).

A number can have a fractional part. A delimiter between an integer part and a fractional part can be either a dot `.` or a comma `,`. A fractional part can't be padded with trailing zeros: for example, 1.01 and 1.0 are valid numbers, but `1.00` and `1.10` are not.

Output "YES" if a given string is a valid number, otherwise output "NO".

## Examples
**Sample Input 1:**
```console
123
```

**Sample Output 1:**
```console
YES
```

**Sample Input 2:**
```console
0123
```

**Sample Output 2:**
```console
NO
```

**Sample Input 3:**
```console
-56.0
```

**Sample Output 3:**
```console
YES
```

**Sample Input 4:**
```console
-0,05
```

**Sample Output 4:**
```console
YES
```

**Sample Input 5:**
```console
-23.230
```

**Sample Output 5:**
```console
NO
```

**Sample Input 6:**
```console
+12376352189432535347623423443417,36817231873134176345178234234234234
```

**Sample Output 6:**
```console
YES
```

## Tags
- additional instruments
- regular expressions
- patterns and matcher
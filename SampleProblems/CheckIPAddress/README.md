#  Check IP address

## Description
An IP address consists of four numbers from 0 to 255, inclusive, divided by the dots. For example, 127.0.0.1 is a valid IP address, but 256.0.0.1 and 127.0.1 are invalid IP addresses.

For a given string output "YES" if this string is a valid IP address, otherwise output "NO".

## Examples
**Sample Input 1:**
```console
127.0.0.1
```

**Sample Output 1:**
```console
YES
```

**Sample Input 2:**
```console
256.0.0.1
```

**Sample Output 2:**
```console
NO
```

**Sample Input 3:**
```console
127.0.1
```

**Sample Output 3:**
```console
NO
```

**Sample Input 4:**
```console
192.168.123.231
```

**Sample Output 4:**
```console
YES
```

**Sample Input 5:**
```console
-1.0.0.1
```

**Sample Output 5:**
```console
NO
```

**Sample Input 6:**
```console
127.0.0.1.
```

**Sample Output 6:**
```console
NO
```

## Tags
- regular expressions
- regexes in programs
- string matches
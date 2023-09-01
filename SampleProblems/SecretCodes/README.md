# Secret codes

## Description
You've found a sequence of codes on the Internet in the HEX format (hexadecimal numbers). You have an assumption that this sequence has a secret subsequence enclosed between `"#0000"` and `"#FFFF"`. Apply your knowledge of Stream API to extract all codes between them (excluding both `"#0000"` and `"#FFFF"`).

Please, try to use `takeWhile` and `dropWhile` methods as well as some predicate to solve this problem.

## Examples
**Sample Input 1:**
```console
#88D4 #0000 #ACCD #444C #FFFF #5E62
```

**Sample Output 1:**
```console
#ACCD #444C
```

**Sample Input 2:**
```console
#0000 #AAAA #FFFF
```

**Sample Output 2:**
```console
#AAAA
```

## Tags
- functional programming
- functional streams
- taking elements
# Compression algorithm

## Description
Upon learning that DNA is not a random string, freshmen of the Bioinformatics Institute from the informatics group suggested using a compression algorithm that compresses repeated characters in a string.

Encoding is performed as follows:
The string **"aaaabbсaa"** is converted into **"a4b2с1a2"**, that is, the groups of the same characters of the input string are replaced by the symbol and the number of its repetitions in this string.

Write a program, which reads the string, encodes it by this algorithm and outputs the encoded sequence. The encoding must be case sensitive.

Note, string can contain only a single character.

## Examples
**Sample Input 1:**
```console
aaaabbcaa
```

**Sample Output 1:**
```console
a4b2c1a2
```

**Sample Input 2:**
```console
abc
```

**Sample Output 2:**
```console
a1b1c1
```

**Sample Input 3:**
```console
aaaaa
```

**Sample Output 3:**
```console
a5
```

## Tags
- strings
- processing strings
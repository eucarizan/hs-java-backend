# Triples

## Description
Write a program that reads an array of ints and outputs the number of "triples" in the array.

A "triple" is three consecutive ints in increasing order differing by 1 (i.e. 3,4,5 is a triple, but 5,4,3 and 2,4,6 are not). Triples may overlap. For example, the sequence 1, 2, 3, 4, 5 contains three triples: 1, 2, 3; 2, 3, 4; and 3, 4, 5.

**Input data format**

The first line contains the size of an array.
The second line contains elements of the array separated by spaces.

**Output data format**

Only a single integer value: the number of "triples".

## Examples
**Sample Input 1:**
```console
6
1 2 4 5 6 7
```

**Sample Output 1:**
```console
2
```

**Sample Input 2:**
```console
6
1 4 7 5 4 3
```

**Sample Output 2:**
```console
0
```

## Tags
- working with data
- arrays
- iterating over arrays
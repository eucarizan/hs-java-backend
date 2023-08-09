# Backward indexes

## Description
Implement a method that returns an element by the specified index from a list. The method must return an element by its regular or backward index.

In the regular order, elements have indexes **0, 1, 2, ..., n – 1**. In the backward order, the same elements have indexes **-n, -n + 1, ..., -2, -1**; where n is the size of a list.

If the specified index is out of bounds, the method must throw the standard IndexOutOfBoundsException.

**Example.** The input list consists of four elements: [100 202 300 401]. If the specified index is 0, the method should return 100; if the specified index is -1 the method should return 401; if the specified index is -2, the method should return 300.

## Examples
**Sample Input 1:**
```console
100 202 300 401
0
```

**Sample Output 1:**
```console
100
```

**Sample Input 2:**
```console
100 202 300 401
-1
```

**Sample Output 2:**
```console
401
```

**Sample Input 3:**
```console
100 202 300 401
-2
```

**Sample Output 3:**
```console
300
```

## Tags
- working with data
- collections
- collections framework
- the list interface
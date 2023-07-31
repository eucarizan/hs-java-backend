# Boxes

## Description
There are two boxes on the table. The first box has a size of X1 x Y1 x Z1, and the second box has a size of X2 x Y2 x Z2.
You need to determine whether one of the boxes can be put inside the other. It should go in without sticking out.
You can rotate both boxes as you want.

**Important:** two equally sized boxes cannot be placed inside one another. See the third test case as an example of how the borderline case should be treated.

Input consists of two lines:
- the first line contains numbers X1, Y1, Z1;
- the second line contains numbers X2, Y2, Z2.

All numbers are integers and greater than 0.

Output:
- "Box 1 < Box 2", if the first box can be put inside the second box ;
- "Box 1 > Box 2", if the second box can be put inside the first box;
- otherwise, output "Incompatible".

## Tip
ne box can be placed inside the other only if it is strictly smaller by all three dimensions. It does not necessarily mean that boxes cannot have one equal side, as you can rotate them.

## Example
**Sample Input 1:**
```console
1 2 3
5 6 4
```

**Sample Output 1:**
```console
Box 1 < Box 2
```

**Sample Input 2:**
```console
2 9 4
3 8 1
```

**Sample Output 2:**
```console
Box 1 > Box 2
```

**Sample Input 3:**
```console
1 3 7
2 8 3
```

**Sample Output 3:**
```console
Incompatible
```
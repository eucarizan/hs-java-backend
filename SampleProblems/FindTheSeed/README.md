# Find the seed

## Description
Your job is to find the seed between **A** and **B** (both inclusive) that produces **N** pseudorandom numbers from **0** (inclusive) to **K** (exclusive). It should also have the maximum of these **N** numbers to be the minimum among all maximums of other seeds in this range.

Sounds complicated? Take a look at the example.

Here we have **A = 7**, **B = 9**, **N = 4**, **K = 100**. Let's suppose:

- For the seed **7**, we get the sequence 36, 64, 85, 44 – the maximum is **85**.
- For the seed **8**, we get 64, 56, 30, 21 – the maximum is **64**.
- For the seed **9**, we get 89, 96, 48, 35 – the maximum is **96**.

Then the minimum among these maximums is **64**. That means, in this example, the seed we are looking for is **8**.

The input contains numbers **A**, **B**, **N**, **K** in a single line and in this order.

Your task is to output 2 numbers: a seed and its maximum. If there are some seeds with equal minimal maximums, you should output the seed that is smaller than all other seeds.

## Examples
**Sample Input 1:**
```console
0 100 5 1000
```

**Sample Output 1:**
```console
18
270
```

**Sample Input 2:**
```console
0 100 1000 1000
```

**Sample Output 2:**
```console
5
993
```

**Sample Input 1:**
```console
0 100 10000 1000
```

**Sample Output 1:**
```console
0
999
```
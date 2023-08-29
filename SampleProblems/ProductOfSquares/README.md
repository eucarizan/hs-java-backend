# The product of squares

## Description
Write a collector that evaluates the product of the squares of the integer numbers in a **Stream<Integer>**.

**Important**. You should write only the collector in **any valid format but without ";" on the end**.

It will be passed as an argument to the **collect()** method of a stream as shown below.

```java
List<Integer> numbers = ...
long val = numbers.stream().collect(...your_collector_will_be_passed_here...);
```

**Examples** of valid solution formats: **Collectors.reducing(...)** or **reducing(...)**.

## Examples
**Sample Input 1:**
```console
0 1 2 3
```

**Sample Output 1:**
```console
0
```

**Sample Input 2:**
```console
1 2
```

**Sample Output 2:**
```console
4
```


## Tags
- tags
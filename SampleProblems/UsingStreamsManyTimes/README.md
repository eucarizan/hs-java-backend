# Using streams many times

## Description
>Wow! This problem is kind of tricky. If you're ready to put your thinking cap on, brace yourself, and good luck! Otherwise, you can skip it for now and return any time later.

Sometimes after mapping and filtering a stream, you need to use it more than one time. For example, find the maximum and count all the elements of a resulting sequence. But it is impossible to do using the standard stream API.

In this practice, you must implement a method to solve this problem. The method should save the stream and create a supplier, that can return this stream over and over again.

You can look at the hints and useful links if you aren't sure how to solve the problem.

For example, this code should output 4, 8, 2 on separate lines:

```java
Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
Supplier<Stream<Integer>> saved = saveStream(stream.filter(e -> e % 2 == 0));

System.out.println(saved.get().count());
System.out.println(saved.get().max(Integer::compareTo).get());
System.out.println(saved.get().min(Integer::compareTo).get());
```

## Examples
**Sample Input 1:**
```console
1 2 3 4 5 6 7 8
```

**Sample Output 1:**
```console
4
8
2
```

## Tags
- functional programming
- functional streams
- stream pipelines
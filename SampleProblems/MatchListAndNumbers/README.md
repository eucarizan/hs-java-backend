# Match lists and numbers

## Description
You have a list numbers:

```java
List<Integer> numbers = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
What numbers does the list generated contain?
```

a)
```java
List<Integer> generated = numbers.stream()
.flatMap(n -> Stream.generate(() -> n).limit(n))
.collect(Collectors.toList());
```

b)
```java
List<Integer> generated = numbers.stream()
.flatMapToInt(n -> IntStream.rangeClosed(1, n))
.boxed()
.collect(Collectors.toList());
```

c)
```java
List<Integer> generated = numbers.stream()
.flatMapToInt(n -> IntStream.iterate(n, val -> val + 1).limit(n))
.boxed()
.collect(Collectors.toList());
```

d)
```java
List<Integer> generated = numbers.stream()
.flatMap(Stream::of)
.collect(Collectors.toList());
```

## Choices
- [1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5]
- [1, 1, 2, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 4, 5]
- [1, 2, 3, 3, 4, 5, 4, 5, 6, 7, 5, 6, 7, 8, 9]
- [1, 2, 3, 4, 5]

## Tags
- functional programming
- functional streams
- map and flatmap
# Finding max and min elements

## Description
Implement a method for finding min and max elements of a stream in accordance with a given comparator.

The found elements pass to `minMaxConsumer` in the following way:

```java
minMaxConsumer.accept(min, max);
```

If the stream doesn't contain any elements, invoke:

```java
minMaxConsumer.accept(null, null);
```

## Tags
- functional programming
- functional streams
- functional data processing with streams
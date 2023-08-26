# Long ranges

## Description
What does this code print?

```java
boolean result = !IntStream
        .generate(() -> 100)
        .limit(101)
        .allMatch(val -> val >= 100);

System.out.println(result);
```

## Tags
- functional programming
- functional streams
- functional data processing with streams
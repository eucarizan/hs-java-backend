# Mapping countries again

## Description
Given the following list of countries:

```java
List<String> countries = Arrays.asList("Costa Rica", "Greece", "Malaysia", "Peru");
```

Enter all elements of the list `numbers` separated by spaces (for example: 1 2 3).

```java
List<Integer> numbers = countries.stream()
        .map(country -> country.split("\\s+"))
        .flatMap(Arrays::stream)
        .map(String::length)
        .collect(Collectors.toList());
```

## Tags
- functional programming
- functional streams
- map and flatmap
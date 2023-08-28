# Mapping countries

## Description
Given the following list of countries:

```java
List<String> countries = Arrays.asList("Costa Rica", "Hungary", "Saint Kitts and Nevis", "Norway");
```

Enter all elements of the list `numbers` separated by spaces (for example: 1 2 3).

```java
List<Integer> numbers = countries.stream()
        .map(country -> country.split("\\s+"))
        .map(country -> country.length)
        .collect(Collectors.toList());
```

## Tags
- functional programming
- functional streams
- map and flatmap
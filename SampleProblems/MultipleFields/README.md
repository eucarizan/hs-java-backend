# Multiple fields

## Description
You have a `User` class with two fields: `String name` and `int age`. Implement a method that takes a list of users, `List<User>`, and sorts it according to the following rule:

Users should be sorted by their names in lexicographic order and if two or more users have the same names, they should be sorted by their age in descending order. You don't need to read or write anything from or to the console, just implement the method.

Tip: The `User` class actually does not impose any limitations on the values its fields may contain, however we can guarantee that they will never be `null`

## Examples
**Sample Input 1:**
```console
John=25, Jane=25, Jim=18, Jack=18, John=30
```

**Sample Output 1:**
```console
Jack=18, Jane=25, Jim=18, John=30, John=25
```

**Sample Input 2:**
```console
Abby=19, Alice=19, Abby=21, Alice=21, Ashley=19
```

**Sample Output 2:**
```console
Abby=21, Abby=19, Alice=21, Alice=19, Ashley=19
```

## Tags
- working with data
- collections
- collections framework
- comparator
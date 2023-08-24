# Sort users

## We have the User class shown in the following code snippet and we want to sort users by their names in the lexicographic order.

```java
class User {
private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
```

Implement UserComparator that we will use to sort users. You don't need to read or write anything from or to the console, just implement the method.

## Examples
**Sample Input 1:**
```console
Mike Ginger Alice Bob
```

**Sample Output 1:**
```console
Alice Bob Ginger Mike
```

**Sample Input 2:**
```console
microprogrammer Moses Chloe user
```

**Sample Output 2:**
```console
Chloe Moses microprogrammer user
```

## Tags
- working with data
- collections
- collections framework
- comparator
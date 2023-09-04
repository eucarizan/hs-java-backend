# An infinite numbers supplier

## Description
Create a supplier that returns integer values from 0 to infinity.

At the first `get()` invocation the supplier must return 0. After the second one, it must return 1, the next one returns 2, 3, etc.

So this code should print "0 1 2 3 4 ":

```java
Supplier<Integer> sup = getInfiniteRange();
for(int i = 0; i < 5; i++) {
System.out.print(sup.get() + " ");
}
```

Also, it should be possible to use separate suppliers simultaneously.

For example, this code should print "0 0 1 1 2 2 3 3 4 4 ":

```java
Supplier<Integer> sup1 = getInfiniteRange();
Supplier<Integer> sup2 = getInfiniteRange();

for(int i = 0; i < 5; i++) {
System.out.print(sup1.get() + " " + sup2.get() + " ");
}
```

Hint: Anonymous class can be helpful here.

## Tags
- functional programming
- functions
- standard functional interfaces
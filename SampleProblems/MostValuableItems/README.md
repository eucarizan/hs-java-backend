# Most valuable items

## Description
This time we have the following `StockItem` class which has three fields: `String name`, `double pricePerUnit`, and `int quantity`.

```java
class StockItem {
private String name;
private double pricePerUnit;
private int quantity;

    public StockItem(String name, double pricePerUnit, int quantity) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + ": " + pricePerUnit + ", " + quantity + ";";
    }

    // getters
}
```

Write a method that accepts a list of `StockItem` objects, sorts them by their total value in descending order, and returns the sorted list. You don't need to read or write anything from or to the console, just implement the method.

## Examples
**Sample Input 1:**
```console
nails: 0.01, 512; hammers: 7.5, 24; screws: 0.02, 318
```

**Sample Output 1:**
```console
hammers: 7.5, 24; screws: 0.02, 318; nails: 0.01, 512
```

**Sample Input 2:**
```console
pens: 3.72, 40; pencils: 1.45, 75; notebooks: 0.84, 130
```

**Sample Output 2:**
```console
pens: 3.72, 40; notebooks: 0.84, 130; pencils: 1.45, 75
```

## Tags
- working with data
- collections
- collections framework
- comparator
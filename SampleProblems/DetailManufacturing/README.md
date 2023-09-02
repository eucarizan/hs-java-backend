# Detail manufacturing

## Description
John decided to create a manufacturing firm. It produces various, mainly mechanical details. John wants to automate details producing requests, but sadly he cannot write code. He asks you to write a simple manufacturing controller.

You are given two methods, `requestProduct` and `getNumberOfProducts`:

1. `getNumberOfProducts` should return the total number of requested products;
2. `requestProduct` should keep track of requested products, and format the product argument in the format: `No. Requested Detail`.

For example:
```java
ManufacturingController.requestProduct("detail 1");
```

should return:
```console
1. Requested detail 1
```

and
```java
ManufacturingController.requestProduct("Wrench");
```

should return:
```console
2. Requested Wrench
```

After execution of these two commands,
```java
ManufacturingController.getNumberOfProducts();
```

should return:
```console
2
```

## Tags
- oop
- classes and objects
- classes and members
- static members
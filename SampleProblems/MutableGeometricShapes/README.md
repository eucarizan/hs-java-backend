# Mutable geometric shapes

## Problem
Suppose, you are writing a geometric engine. Now it includes classes `Circle`, `Rectangle` and interfaces `Movable` and `Scalable`.

**You need:**

1. to write a new interface `MutableShape` that extends both existing interfaces;
2. to implement the new interface in each class;
3. to override methods `move` and `scale` in both classes:
    - `scale` should multiply the radius of a circle by the specified `factor`;
    - `scale` should multiply width and height of a rectangle by the specified `factor`;
    - `move` should add `dx` and `dy` to the center of a circle;
    - `move` should add `dx` and `dy` to the upper-left corner of a rectangle.

See the provided code and read comments to understand your task better. The code is not compiled.

**Note:**
- do not remove existing classes and their members (including getters and constructors).
- do not make your classes and interfaces `public`

After your changes, the following code should be compiled:
```java
MutableShape circle = new Circle(2.0f, 3.5f, 10.1f);

circle.move(10.1f, 20.2f);
circle.scale(2.2f);

((Circle) circle).getRadius();
```

## Tags
- oop
- class hierarchies
- interfaces and abstract classes
- interface
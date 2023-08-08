# Build a house

## Description
There are three classes: an abstract class `House`, and two concrete classes, `Wooden` and `Stone`.
You must implement the abstract class `House` with a template method called `build()` to build a new house using the following algorithm:

1. Choose a location
2. Place a foundation
3. Place walls
4. Place windows
5. Place doors
6. Place roofs
7. Connect the house to the electrical grid

The `Stone` class is already provided. Use it to help you write the abstract methods in the abstract `House` class.
Make the `Wooden` class inherit from the `House` class and implement the methods according to the console output.

## Examples
**Sample Input 1:**
```console
stone
```

**Sample Output 1:**
```console
Choose the best location for the new house
Place a stone foundation
Place stone walls
Place reinforced windows
Place reinforced doors
Place metal sheet roofs
Connect the house to the electrical grid
```

**Sample Input 2:**
```console
wooden
```

**Sample Output 2:**
```console
Choose the best location for the new house
Place a wooden foundation
Place wooden walls
Place wooden windows
Place wooden doors
Place metal sheet roofs
Connect the house to the electrical grid
```
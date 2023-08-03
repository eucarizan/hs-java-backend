# Don't be late again

## Description
Yesterday an unfortunate thing happened. You wanted to visit a grocery store, it was late and one by one the stores already started to close. You've decided to go to Kwik-E-Mart to buy some doughnuts, but when you reached it, the store was already closed.

To avoid such situations, you've prepared a list of stores nearby with their closing time. To get to any of them you need exactly **30 minutes**.

Now your job is to write a program that determines which stores you will be able to reach today if you go out at exactly **19:30**.

## Input data format
The first line contains a number of stores in the list. The following lines contain information about the stores with two attributes: _store name_ and the _closing time_. They are separated by one space (a name cannot have spaces).

## Output data format
Grocery stores you will be able to reach in 30 minutes. The order of stores in the output should be the same as in the input. Each store is in a new line.

## Examples
**Sample Input 1:**
```console
4
Tastyday 20:30
Food 20:00
Zehrs 19:00
Bonus 20:20
```

**Sample Output 1:**
```console
Tastyday
Bonus
```
# Healthy sleep

## Description
Ann watched a health TV program and learned that oversleeping is as bad for your health as not getting enough sleep. She decided to follow TV recommendations and keep track of how many hours she spends sleeping.

You are **given** three numbers: _A_, _B_ and _H_. According to TV, one should sleep at least _A_ hours per day, but no more than _B_ house. _H_ is how many hours Ann sleeps.

## Task
If Ann sleeps than _A_ hours, print "Deficiency".
If she sleeps more than _B_ hours, print "Excess".
If her sleeps fits the recommendation, print "Normal".

## Input format
three numbers _A_, _B_, _H_, where _A_ is always less than or equal to _B_.

## Tip
1. Keep in mind that tests are case-sensitive: "excess" or "EXCESS" is not correct.
2. Think **carefully** about all the conditions. Pay attention to the conditional operators: distinghuish between < and <=; > and >=;

## Example
**Sample Input 1:**
```console
6
10
8
```

**Sample Output 1:**
```console
Normal
```

**Sample Input 2:**
```console
7
9
10
```

**Sample Output 2:**
```console
Excess
```

**Sample Input 1:**
```console
7
9
2
```

**Sample Output 1:**
```console
Deficiency
```

## Tags
- control flow statements
- conditional statement
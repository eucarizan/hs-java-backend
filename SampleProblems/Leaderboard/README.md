# Leaderboard

## Description
There is an application to create leaderboards of e-sports competitions. It uses the Score class to represent a score of each player. This class has two fields: player for the player's name and totalScore for that player's total score. To build a leaderboard, the Score objects need to be compared. A Score object is considered bigger than another Score if it's totalScore value is bigger. If totalScore values of two Score objects are the same, such objects must be compared by their player values. See the example below.

## Examples
**Sample Input 1:**
```console
Ann 162
Zipper 121
Flash 121
CoolDoge 200
```

**Sample Output 1:**
```console
[Flash=121, Zipper=121, Ann=162, CoolDoge=200]
```

## Tags
- oop
- class hierarchies
- interfaces and abstract classes
- comparable
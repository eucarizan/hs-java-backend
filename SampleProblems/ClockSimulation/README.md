# Simulating a clock

## Description
You are given a class `Clock`. It has two int fields: `hours` and `minutes`. The clock has a minute scale from 0 to 59 and an hour scale from 1 to 12. The clock does not know whether it's day or night (no AM or PM).

Implement the method `next` that increases the value of minutes by 1. The minutes must be reset to zero when the current hour ends. Do not forget to change the hours as well.

Do not make the fields and methods `private`.

## Example
Let's consider the examples.

1. The initial time of the object `clock` is 12:00, i.e., `hours = 12` and `minutes = 0`. Applying the `next` method to the `clock`, we change its field `minutes` to `minutes = 1`. In this way, the time is 12:01.
```java
Clock clock = new Clock(); // the time is 12:00
clock.next(); // the time is 12:01
```

2. The initial time of a `clock` object is 10:59, i.e. `hours = 10` and `minutes = 59`. After applying the `next` method to the `clock`, we turn its fields to `hours = 11` and `minutes = 0`, i.e., the time is 11:00 now.
```java
Clock clock = new Clock();
clock.hours = 10;
clock.minutes = 59;
// time is 10:59

clock.next(); // the time is 11:00
```
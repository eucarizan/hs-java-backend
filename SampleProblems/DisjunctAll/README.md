# Disjunct all

## Description
It is time to learn how to perform operations on predicates, just like in mathematical logic!

Write the `disjunctAll` method that accepts a list of `IntPredicate` objects and returns a single `IntPredicate`. The result predicate is a **disjunction** of all input predicates.

**Disjunction** means that if any of the predicates would return `true`, the composed predicate should return `true` as well.

If the input list is empty, the resulted predicate must return `false` for any integer value **(always false predicate)**.

## Tags
- functional programming
- functions
- function composition
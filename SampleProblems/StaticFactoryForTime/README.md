# Static factory methods for Time

## Description
The normal way to create an instance of a class is to use a public constructor of the class. But there is another technique. A class can provide a public static factory method that returns an instance of the class. An advantage of static factory methods is that they have names that make the code easier to read.

In this problem, you have the class `Time` containing three fields: `hour`, `minute` and `second`. Implement the following static factory methods of this class:

- `noon()` returns an instance initialized with 12 hours, 0 minutes, and 0 seconds.
- `midnight()` returns an instance initialized with 0 hours, 0 minutes, and 0 seconds.
- `of(int hour, int minute, int second)` returns an instance initialized with passed hour, minute and second if the passed arguments are correct (hour: 0-23, minute: 0-59, seconds: 0-59), otherwise, `null`.
- `ofSeconds(long seconds)` returns an instance initialized with seconds passed since midnight; as an example, the invocation `Time.ofSeconds(500000)` must create an instance with 18 hours, 53 minutes and 20 seconds (days are skipped);

As you see, the methods are more readable than the same constructors. If you want to create an instance of `Time` representing noon, you can write:

```console
Time noon = Time.noon();
```

Note:

- do not change fields of the class `Time`;
- in a real application, it may be better to throw an exception than return `null` when arguments are incorrect.

You must not read or output something in this problem. Just implement the static factory methods.

## Tags
- code organization
- design patterns
- creational patterns
- encapsulating object creation
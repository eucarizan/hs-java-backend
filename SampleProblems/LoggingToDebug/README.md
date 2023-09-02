# Logging to debug

## Description
You have the `Solution` class with the method `add` that calculates and returns a sum of two arguments.

Your task is to add a logger to this class with the name of that class and log a message at the **debug level** indicating both arguments and the resulting sum. For example, if the first argument is 3 and the second argument is 5, then the message should be in the following format:

`arg1=3, arg2=5, sum=8`

In this case, the entire log message would look like this:
```java
08:55:58.618 [Main] DEBUG logbacktasks.Solution - arg1=3, arg2=5, sum=8
```

## Tags
- errorless code
- logging
- logback
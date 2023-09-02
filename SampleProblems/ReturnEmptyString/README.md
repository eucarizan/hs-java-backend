# Return empty string when argument is null

## Description
Take a look at the method that takes a string, converts all characters of the string to upper case, and then returns the resulting string.

But there is a problem. Sometimes an input string is `null`. As you already know, in this case, the method throws a `NullPointerException`.

Your task is to fix the method in order to avoid an **NPE**.

If the input string is `null`, the method should return the empty string "".

## Examples
**Sample Input 1:**
```console
a string
```

**Sample Output 1:**
```console
A STRING
```

## Tags
- errorless code
- exception handling
- npe
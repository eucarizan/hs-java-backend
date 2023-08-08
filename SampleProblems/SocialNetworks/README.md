# Social networks

## Description
There are three classes: an abstract class called `SocialNetwork`, and two concrete classes, `Instagram` and `Facebook`.
Your task is to implement the abstract class `SocialNetwork` with a template method called `connect()` and three abstract methods using the following algorithm:

1. Log in
2. Post a message
3. Log out

Make `Instagram` and `Facebook` inherit from the `SocialNetwork` class and implement the methods according to the console output.

## Examples
**Sample Input 1:**
```console
instagram
```

**Sample Output 1:**
```console
Log into Instagram
Post: Hello, Instagram!
Log out of Instagram
```

**Sample Input 2:**
```console
facebook
```

**Sample Output 2:**
```console
Log into Facebook
Post: Hello, Facebook!
Log out of Facebook
```
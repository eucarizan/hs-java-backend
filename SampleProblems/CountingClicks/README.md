# Counting clicks

## Description
There is a `LogEntry` class for monitoring user activity on your site. The class has three fields:

- `created`: **Date** is the date of creating log entry;
- `login`: **String** is a user login;
- `url`: **String** is a url that the user clicked.

and getter for `url` field: `getUrl()`.

Write a collector that calculates how many times each `url` was clicked by users. The collector will be applied to a stream of log entries for creating a map: **url -> click count**.

## Tags
- functional programming
- functional streams
- grouping collectors
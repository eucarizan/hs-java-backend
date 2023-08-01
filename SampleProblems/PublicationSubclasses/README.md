# Publication and its subclasses


## Description
You are given four classes — `Publication`, `Newspaper`, `Article` and `Announcement`. You need to override the methods `getType()` and `getDetails()` in classes inherited from the class Publication.

Then you need to implement `getInfo()` in the class `Publication` using `getType()` and `getDetails()`. The method should return a `String` with a type of publication in the first place, then details in round brackets and the title after a colon. Examples are shown below.

## Examples
**Sample Input 1:**
```console
Publication; The new era
```

**Sample Output 1:**
```console
Publication: The new era
```

**Sample Input 2:**
```console
Newspaper; Football results; Sports news
```

**Sample Output 2:**
```console
Newspaper (source - Sport news): Football results
```

**Sample Input 3:**
```
Article; Why the Sun is hot; Dr James Smith
```

**Sample Output 3:**
```
Article (author - Dr James Smith): Why the Sun is hot
```

**Sample Input 4:**
```
Announcement; Will sell a house; 30
```

**Sample Output 4:**
```
Announcement (days to expire - 30): Will sell a house
```
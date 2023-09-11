# Create an euphonious word

## Description
All the letters of the English alphabet are divided into vowels and consonants.
The vowels are: a, e, i, o, u, y.
The remaining letters are consonants.

A word is considered euphonious (pleasant-sounding) if it doesn't have three or more vowels or consonants in a row. Otherwise, it is considered discordant (harsh-sounding).

Your task is to create euphonious words from discordant. You can insert any letters inside the word. You should output the minimum number of characters needed to create a euphonious word from a given word.

For example, the word "schedule" is considered discordant because it has three consonants "sch" in a row. To create a euphonious word you need to add any vowel between 's' and 'c' or between 'c' and 'h'.

## Examples
**Sample Input 1:**
```console
schedule
```

**Sample Output 1:**
```console
1
```

**Sample Input 2:**
```console
garage
```

**Sample Output 2:**
```console
0
```

**Sample Input 3:**
```console
player
```

**Sample Output 3:**
```console
1
```

**Sample Input 4:**
```console
biiiiig
```

**Sample Output 4:**
```console
2
```

## Tags
- strings
- processing strings
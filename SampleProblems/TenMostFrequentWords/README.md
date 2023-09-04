# The ten most frequent words

## Description
> Wow! This problem is kind of tricky. If you're ready to put your thinking cap on, brace yourself and good luck! Otherwise, you can skip it for now and return any time later.

Write a program that reads a text (in the UTF-8) from the standard input. The program must count the frequency of words in the text and print the 10 most frequent words.

A word is a sequence of characters consisting only of digits and letters. For example, the string `"Functions bring happiness!"` has three words: `"Functions"`, `"bring"`, `"happiness"`.

The counting words should be case-insensitive, i.e. `"Functions"`, `"functions"` and `"FUNCTIONS"` are the same word. Output words in the lower case.

If the text has less than 10 unique words, output as many as there are.

If some words in the text have the same frequency, sort them according to [the lexicographical order](https://en.wikipedia.org/wiki/Lexicographical_order).

The problem has a beautiful solution using streams without any loops and conditional operators. Try to write it.

## Examples
**Sample Input 1:**
```console
Functions bring happiness!
```

**Sample Output 1:**
```console
bring
functions
happiness
```

**Sample Input 2:**
```console
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.
```

**Sample Output 2:**
```console
consectetur
faucibus
ipsum
lorem
adipiscing
amet
dolor
eget
elit
mi
```

## Tags
- functional programming
- functional streams
- stream pipelines
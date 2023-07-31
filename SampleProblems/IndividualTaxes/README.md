# Individual taxes

## Problem
In some country, there are N companies, and the law of that country says that the taxes of each company are individual and appointed by the president. The president wants to know which company pays the most taxes. But sadly, none of the president's proxies know math very well, so this work is transferred to you. Can you solve this problem?

1. The first line of the input contains N which is the number of companies in the country.
2. The second line contains the yearly incomes of each company. All numbers are non-negative integers.
3. The third line contains individual taxes for each company in percent of the company's income. All numbers are integers from 0 to 100 inclusive.

You should output the number of the company that pays the most taxes. Keep in mind that the enumeration of the companies starts with number 1. If there are several companies with the same payment sizes, output the number of the company with the lowest number.

Note: be careful not to lose fractional parts while performing your calculations. All input and output numbers are integers, but you may have to use a different type for storing intermediate values.

## Example
**Sample Input 1:**
```console
1
1
1
```
**Sample Output 1:**
```console
1
```

**Sample Input 2:**
```console
2
50 100
10 10
```
**Sample Output 2:**
```console
2
```

**Sample Input 3:**
```console
3
50 100 300
100 20 0
```
**Sample Output3:**
```console
1
```
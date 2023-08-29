# How many date-time pairs match the range

## Description
Write a program that determines whether the _date-time_ pairs belong to the specified _time range_ (including the earlier date-time and excluding the later) and _counts the number_ of such dates. The number of date-time pairs to process **N** should be specified by the user. Each pair has the **year**-**month**-**day**T**hour**:**minute** format.

If the borders of the range are equal and a date-time is equal to them, such date-time is not considered as belonging to the range.

**Input data format**

The first line contains a border of the range (either earlier or later). The second line contains the other border of the range. The third line contains an integer number **N**: a number of date-time pairs. The following N lines consist of date-time pairs.

**Output data format**

The program must output an _integer number_: the count of date-time pairs belonging to the given range.

>**Important**: the first and the second input dates do not correspond to the start and the end date. The program must determine which date is earlier.


## Examples
**Sample Input 1:**
```console
2017-12-01T00:10
2017-12-02T00:10
3
2017-12-01T00:10
2017-12-01T13:50
2017-12-02T00:10
```

**Sample Output 1:**
```console
2
```

**Sample Input 2:**
```console
2017-12-31T23:59
2017-12-01T00:00
1
2017-12-01T00:00
```

**Sample Output 2:**
```console
1
```

## Tags
- essential standard classes
- date and time
- comparing dates and times
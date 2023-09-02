# Tricky sub-maps

## Description
> Wow! This problem is kind of tricky. If you're ready to put your thinking cap on, brace yourself and good luck! Otherwise, you can skip it for now and return any time later

Modify and return the given map as follows:

- if the first key % 2 != 0, return sub-map from **firstKey** inclusive to **firstKey + 4** inclusive in descending order;
- else return sub-map from **lastKey – 4** inclusive to the **lastKey** inclusive in descending order.

**Tip:**

To make `TreeMap` store elements in descending order you can create it this way: `new TreeMap<>(Collections.reverseOrder());`

To put all elements from one map to another map you can do `anotherMap.putAll(map)`

## Examples
**Sample Input 1:**
```console
1:one 2:two 3:three 4:four 5:five 6:six 7:seven
```

**Sample Output 1:**
```console
5 : five
4 : four
3 : three
2 : two
1 : one
```

**Sample Input 2:**
```console
2:two 4:four 6:six 8:eight 10:ten 12:twelve 14:fourteen
```

**Sample Output 2:**
```console
14 : fourteen
12 : twelve
10 : ten
```

## Tags
- collections
- collections framework
- the map interface
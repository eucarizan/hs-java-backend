# Max and Min

## Description
Use the strategy pattern to implement algorithms to find max and min values in a given array. The basic structure of the provided classes is described below: your job is to complete it.

The class Finder represents the general finding algorithm itself. It has `find(int[] numbers)` method that returns the result of finding according to the specified strategy.

The interface `FindingStrategy` provides `getResult()` method to write new concrete finding strategies.

Please, do not change the interface `FindingStrategy`, and do not rename the existing methods.

If the array is empty, the `Finder` should return `Integer.MAX_VALUE` in case of finding the min value and `Integer.MIN_VALUE` in case of finding the max value.

## Hints
- Tests 1-5 check `MinFindingStrategy`, tests 6-10 check `MaxFindingStrategy`. Do not forget to check your solution when the passed array has the size 0 or 1.
- 
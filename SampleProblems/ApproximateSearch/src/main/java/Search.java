import java.util.ArrayList;
import java.util.List;

public class Search {
    private static int binarySearch(int[] array, int value) {
        int left = 1;
        int right = array.length;
        int currentMiddle = 0;

        if (value >= array[array.length - 1]) {
            return array[array.length - 1];
        }

        if (value <= array[0]) {
            return array[0];
        }

        while (left <= right) {
            int middle = (left + right) / 2;
            currentMiddle = middle;

            if (array[middle] == value) {
                return array[middle];
            } else if (array[middle] > value) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        if (left > currentMiddle) {
            if (value - array[currentMiddle] <= array[currentMiddle + 1] - value) {
                return array[currentMiddle];
            }
            return array[currentMiddle + 1];
        } else {
            if (value - array[currentMiddle - 1] <= array[currentMiddle] - value) {
                return array[currentMiddle - 1];
            }
            return array[currentMiddle];
        }
    }

    /*
    The main part of the program is looping through the second array and creating a third one, where we will record the result of the search.

    Next, we need to change the search function to meet our requirements.
    If we find the sought number in the array, then it is necessary to return the number itself, not the index.

    If we don't find the number, we get to the line of code 'return -1', but we do not need it.
    Instead, let's check which number we need: more than the current (middle) one or less.
    If at the last step we wanted to get a number larger than the current one, then the left border will go beyond the limit,
    which means the desired number is between the current number and the next one, and vice versa.
    It is also necessary to check that the indexes have not gone beyond the entire array.
    Now we need to find out which number of the two closest ones is closer to the value of the one we are looking for.
    For this, it is enough to calculate the difference between the pairs of numbers and compare the results.
    If the difference turns out smaller, then this number is closer.
     */
    public static List<Integer> approximateSearch(int[] array, int[] values) {
        List<Integer> numbers = new ArrayList<>();

        for (int value : values) {
            int num = binarySearch(array, value);
            numbers.add(num);
        }

        return numbers;
    }
}

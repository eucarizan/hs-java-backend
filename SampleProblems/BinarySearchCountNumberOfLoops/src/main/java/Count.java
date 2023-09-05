public class Count {
    private static int binarySearch(int[] array, int value) {
        int left = 1;
        int right = array.length;
        int count = 0;

        while (left <= right) {
            int middle = (left + right) / 2;
            count++;
            if (array[middle] == value) {
                break;
            } else if (array[middle] > value) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return count;
    }

    public static int countBinarySearch(int[] array, int[] values) {
        int result = 0;

        for (int value : values) {
            result += binarySearch(array, value);
        }

        return result + 1;
    }
}

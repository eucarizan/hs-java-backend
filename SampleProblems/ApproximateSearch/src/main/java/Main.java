import java.util.List;

public class Main {
    public static void main(String[] args) {
//        int[] array2 = {11, 17, 18, 27, 44, 47, 49, 51, 55, 60, 67, 75, 79, 85, 92};
//        int[] values2 = {26, 28, 85, 77, 57, 22, 89, 50, 30, 56, 68, 87, 71, 18, 67};
//
//        List<Integer> result2 = Search.approximateSearch(array2, values2);
//        System.out.println(result2.toString().replaceAll(",", ""));

        int[] array2 = {0, 2, 13, 14, 20, 39, 41, 55, 74, 78, 90, 92, 92, 96, 98};
        int[] values2 = {7, 81, 35, 82, 29, 5, 32, 20, 37, 73, 34, 33, 74, 7, 78};

        List<Integer> result2 = Search.approximateSearch(array2, values2);
        System.out.println(result2);
    }
}
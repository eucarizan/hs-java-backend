public class Main {
    public static void main(String[] args) {
        int[] nums = {10, 8, 4};
        int[] nums1 = {4, 11, 12, 11, 11};
        System.out.println(MaxProduct.selectStream(nums));
        System.out.println(MaxProduct.selectStream(nums1));
    }
}
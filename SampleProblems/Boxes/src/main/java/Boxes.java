import java.util.Arrays;
import java.util.Scanner;

public class Boxes {
    public static void main(String[] args) {
        final int arraySize = 3;

        int[] box1 = new int[arraySize];
        int[] box2 = new int[arraySize];

        setBoxVolume(box1);
        setBoxVolume(box2);
        Arrays.sort(box1);
        Arrays.sort(box2);
        canPutBox(box1, box2);
    }

    private static void setBoxVolume(int[] box) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < box.length; i++) {
            box[i] = scanner.nextInt();
        }
    }

    private static void canPutBox(int[] box1, int[] box2) {
        if (box1[0] > box2[0] && box1[1] > box2[1] && box1[2] > box2[2]) {
            System.out.println("Box 1 > Box 2");
        } else if (box1[0] < box2[0] && box1[1] < box2[1] && box1[2] < box2[2]) {
            System.out.println("Box 1 < Box 2");
        } else {
            System.out.println("Incompatible");
        }
    }
}

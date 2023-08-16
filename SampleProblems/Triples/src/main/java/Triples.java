public class Triples {
    public static int countTriples(int[] array) {
        int triples = 0;

        for (int i = 0; i < array.length - 2; i++) {
            int num = array[i];
            int count = 1;
            for (int j = i + 1; j <= i + 2; j++) {
                int num2 = array[j];
                if (num + 1 == num2) {
                    count++;
                    num = num2;
                } else {
                    break;
                }
            }

            if (count == 3) {
                triples++;
            }
        }

        return triples;
    }

    public static int countTripleMinus(int[] array) {
        int triples = 0;
        for (int i = 2; i < array.length; i++) {
            if (array[i] - array[i - 1] == 1 && array[i - 1] - array[i - 2] == 1) {
                triples++;
            }
        }
        return triples;
    }
}

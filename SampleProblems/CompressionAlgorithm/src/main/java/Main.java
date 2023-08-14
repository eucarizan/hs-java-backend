@SuppressWarnings("SpellCheckingInspection")
public class Main {
    public static void main(String[] args) {
        String input1 = "aaaabbcaa";
        String input2 = "abc";
        String input3 = "aaaaa";
        String input4 = "XXV";

//        processStrings(input1);
//        processStrings(input2);
//        processStrings(input3);
        stringCompress(input1);
        stringCompress(input2);
        stringCompress(input3);
        stringCompress(input4);
    }

    public static void processStrings(String input) {
        int[] letters = new int[26];
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int idx = ch - 'a';
            letters[idx]++;
        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 0) {
                char ch = (char) ('a' + i);
                System.out.printf(ch + "" + letters[i]);
            }
        }
        System.out.println();
    }

    public static void stringCompress(String input) {
        int sum = 1;
        char ch;

        for (int i = 0; i < input.length(); ) {
            ch = input.charAt(i);
            for (int j = i + 1; j < input.length(); j++) {
                char ch2 = input.charAt(j);
                if (ch == ch2) {
                    sum++;
                } else {
                    break;
                }
            }
            System.out.print(ch + "" + sum);
            i += sum;
            sum = 1;
        }
        System.out.println();
    }
}

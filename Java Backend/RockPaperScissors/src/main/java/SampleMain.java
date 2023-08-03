
public class SampleMain {
    static final String[] options = { "rock", "fire", "scissors", "sponge", "paper", "air", "water" };
    static int length = options.length;
//    static String[] resultLine = new String[length];
    static String[] resultLine = { "draw", "loss", "loss", "loss", "win", "win", "win" };
    static String[][] results = new String[length][length];

    @SuppressWarnings("unused")
    private static void createResultMatrix() {
        for (int i = 0; i < length; i++) {
            for (int j = i, k = 0; k < length; j++, k++) {
                if (j >= length) {
                    j = 0;
                }
                results[i][j] = resultLine[k];
            }
        }

        for (String[] resultsLine : results) {
            System.out.println(String.join(" ", resultsLine));
        }
    }
    
    @SuppressWarnings("unused")
    private static void createResultLine() {
        resultLine[0] = "draw";

        for (int i = 1; i <= length / 2; i++) {
            resultLine[i] = "loss";
        }

        for (int i = (length / 2) + 1; i < length; i++) {
            resultLine[i] = "win";
        }

        System.out.println(String.join("\", \"", resultLine));
    }
}

import java.util.*;

class Score implements Comparable<Score> {
    private final String player;
    private final int totalScore;

    public Score(String player, int totalScore) {
        this.player = player;
        this.totalScore = totalScore;
    }

    public String getPlayer() {
        return player;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return player + '=' + totalScore;
    }

    @Override
    public int compareTo(Score score) {
        // your code here
        if (totalScore == score.getTotalScore()) {
            return player.compareTo(score.getPlayer());
        }
        return totalScore - score.getTotalScore();
    }
}

// do not change the code below
@SuppressWarnings("unused")
class Main {
    public static void main(String[] args) {
        String[] inputs = {
                "Ann 162",
                "Zipper 121",
                "Flash 121",
                "CoolDoge 200"
        };

        List<Score> scores = new ArrayList<>();

        for (String s : inputs) {
            String[] input = s.split(" ");
            Score score = new Score(input[0], Integer.parseInt(input[1]));
            scores.add(score);
        }

        Collections.sort(scores);
        System.out.println(scores);
    }

    private static void byScanner() {
        try (Scanner sc = new Scanner(System.in)) {
            List<Score> scores = new ArrayList<>();
            while (sc.hasNextLine()) {
                String[] input = sc.nextLine().split(" ");
                Score score = new Score(input[0], Integer.parseInt(input[1]));
                scores.add(score);
            }

            Collections.sort(scores);
            System.out.println(scores);
        }
    }
}
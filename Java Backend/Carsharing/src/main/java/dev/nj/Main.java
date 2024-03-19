package dev.nj;

public class Main {
    public static void main(String[] args) {
        App.start(getDatabaseFileName(args));
    }

    private static String getDatabaseFileName(String[] args) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if ("-databaseFileName".equals(args[i])) {
                if (i + 1 < args.length) {
                    out.append(args[i + 1]);
                }
            }
        }
        return out.toString();
    }
}
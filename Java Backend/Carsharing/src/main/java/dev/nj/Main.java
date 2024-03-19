package dev.nj;

import org.h2.jdbcx.JdbcDataSource;

public class Main {
    public static void main(String[] args) {
        System.out.println(App.start(getDatabaseFileName(args)));
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
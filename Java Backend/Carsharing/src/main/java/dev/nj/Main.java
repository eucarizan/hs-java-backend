package dev.nj;

import dev.nj.controller.CarSharing;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> arguments = Arrays.asList(args);
        int i = arguments.indexOf("-databaseFileName");
        String dbName = i == -1 ? "CarSharingDb" : arguments.get(i + 1);
        CarSharing carSharing = new CarSharing(dbName);
        carSharing.start();
    }
}
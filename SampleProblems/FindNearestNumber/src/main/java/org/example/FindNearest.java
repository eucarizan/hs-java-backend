package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class FindNearest {
    public static ArrayList<Integer> find(int target, ArrayList<Integer> nums) {
        ArrayList<Integer> copyNums = new ArrayList<>();

        int distance = Math.abs(target - nums.get(0));

        for (int i = 1; i < nums.size(); i++) {
            distance = Math.min(distance, Math.abs(target - nums.get(i)));
        }

        for (int num : nums) {
            if (num == target + distance || num == target - distance) {
                copyNums.add(num);
            }
        }

        Collections.sort(copyNums);

        return copyNums;
    }
}

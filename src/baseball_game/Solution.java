package baseball_game;

import java.util.*;

public class Solution {
    /**
     * You are keeping the scores for a baseball game with strange rules.
     * At the beginning of the game, you start with an empty record.
     * You are given a list of strings operations,
     * where operations[i] is the ith operation you must apply to the record and is one of the following:
     * An integer x.
     * Record a new score of x.
     * '+'.
     * Record a new score that is the sum of the previous two scores.
     * 'D'.
     * Record a new score that is the double of the previous score.
     * 'C'.
     * Invalidate the previous score, removing it from the record.
     * Return the sum of all the scores on the record after applying all the operations.
     * The test cases are generated such that the answer and all intermediate calculations fit in
     * a 32-bit integer and that all operations are valid.
     */
    public int calPointsIfStatement(String[] operations) {
        Deque<Integer> pts = new ArrayDeque<>();
        for (String operation : operations) {
            if (operation.matches("-?\\d+")) {
                pts.push(Integer.parseInt(operation));
            } else if (Objects.equals(operation, "C")) {
                pts.pop();
            } else if (Objects.equals(operation, "D")) {
                pts.push(pts.peek() * 2);
            } else if (Objects.equals(operation, "+")) {
                int x = pts.pop();
                int y = pts.pop();
                pts.push(y);
                pts.push(x);
                pts.push(x + y);
            }
        }
        int sum = 0;
        for (Integer n : pts) {
            sum += n;
        }
        return sum;
    }

    public int calPointsSwitch(String[] operations) {
        Deque<Integer> pts = new ArrayDeque<>();
        for (String op : operations) {
            switch (op) {
                case "C" -> pts.pop();
                case "D" -> pts.push(pts.peek() * 2);
                case "+" -> {
                    int x = pts.pop();
                    int y = pts.pop();
                    pts.push(y);
                    pts.push(x);
                    pts.push(x + y);
                }
                default -> pts.push(Integer.parseInt(op));
            }
        }
        return pts.stream().mapToInt(Integer::intValue).sum();
    }
}

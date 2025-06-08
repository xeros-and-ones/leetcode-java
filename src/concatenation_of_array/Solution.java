package concatenation_of_array;

import java.util.Arrays;

public class Solution {
    /**
     * Given an integer array nums of length n, you want to create an array ans of length 2n where
     * ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
     *
     * <p>Specifically, ans is the concatenation of two nums arrays.
     *
     * <p>Return the array ans.
     */
    public static int[] getConcatenation(int[] nums) {
        return getConcatenation(nums, 1);
    }

    public static int[] getConcatenation(int[] nums, int times) {
        int[] ans = new int[nums.length * times];

        for (int j = 1; j < times; j++) {
            for (int i = 0; i < nums.length; i++) {
                ans[i] = nums[i];
                ans[i + (j * nums.length)] = nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getConcatenation(new int[]{1, 2, 1}, 4)));
    }
}

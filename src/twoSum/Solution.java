package twoSum;

import java.util.HashMap;

public class Solution {
    /// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    ///
    ///
    ///
    /// Example 1:
    ///
    /// Input: s = "anagram", t = "nagaram"
    ///
    /// Output: true
    ///
    /// Example 2:
    ///
    /// Input: s = "rat", t = "car"
    ///
    /// Output: false
    ///
    ///
    ///
    /// Constraints:
    ///
    /// 1 <= s.length, t.length <= 5 * 104
    /// s and t consist of lowercase English letters.
    ///
    ///
    /// Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
    public static void twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i : map.keySet()) {

        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        twoSum(new int[]{2, 7, 11, 16}, 18);
    }
}

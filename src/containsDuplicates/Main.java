package containsDuplicates;
import java.util.HashSet;

public class Main {
    /*
    *  Given an integer array nums,
    * return true if any value appears more than once in the array,
    * otherwise return false.
    *
    */

    public static boolean hasDuplicates(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        System.out.println(hasDuplicates(nums));
    }
}

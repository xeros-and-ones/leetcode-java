package remove_element;

public class Solution {
    /// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
    ///  The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
    /// Consider the number of elements in nums which are not equal to val be k,
    ///  to get accepted, you need to do the following things:
    /// Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
    /// The remaining elements of nums are not important as well as the size of nums.
    /// Return k.

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != val || nums[i] ==val) {
                i++;
                nums[i] = nums[j];
            }
            System.out.println(nums[i]);
        }
        return i;
    }

    public static void main(String[] args) {

        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }

}

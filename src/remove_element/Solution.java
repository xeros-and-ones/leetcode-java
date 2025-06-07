package remove_element;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  /// Given an integer array nums and an integer val, remove all occurrences of val in nums
  // in-place.
  ///  The order of the elements may be changed. Then return the number of elements in nums which
  // are not equal to val.
  /// Consider the number of elements in nums which are not equal to val be k,
  ///  to get accepted, you need to do the following things:
  /// Change the array nums such that the first k elements of nums contain the elements which are
  // not equal to val.
  /// The remaining elements of nums are not important as well as the size of nums.
  /// Return k.

  public static int removeElement(int[] nums, int val) {
    if (nums.length == 0) return 0;
    List<Integer> tmp = new ArrayList<>();

    for (int num : nums) {
      if (num != val) {
        tmp.add(num);
      }
    }
    for (int i = 0; i < tmp.size(); i++) {
      nums[i] = tmp.get(i);
    }

    return tmp.size();
  }

  public static void main(String[] args) {

    System.out.println(removeElement(new int[] {3, 2, 2, 3}, 3));
  }
}

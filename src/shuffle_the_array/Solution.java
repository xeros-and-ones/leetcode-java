package shuffle_the_array;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
  public static int[] flattenMap(TreeMap<Integer, Integer> map) {
    int[] res = new int[map.size() * 2];
    int idx = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      res[idx++] = entry.getKey();
      res[idx++] = entry.getValue();
    }
    return res;
  }

  public static int[] shuffle(int[] nums, int n) {

    if (nums.length == 0) return null;

    TreeMap<Integer, Integer> pairs = new TreeMap<>();

    int y = n;
    for (int i = 0; i < n; i++) {
      pairs.put(nums[i], nums[y++]);
    }

    flattenMap(pairs);
    System.out.println(pairs);
    return nums;
  }

  public static void main(String[] args) {
    shuffle(new int[] {2, 5, 1, 3, 4, 7}, 3);
  }
}

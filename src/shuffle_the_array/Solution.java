package shuffle_the_array;

public class Solution {
  public static int[] shuffleLinearSpace(int[] nums, int n) {
    int[] res = new int[nums.length];

    for (int i = 0; i < n; i++) {
      res[2 * i] = nums[i];
      res[2 * i + 1] = nums[i + n];
    }
    return res;
  }

  public static int[] shuffleConstantSpace(int[] nums, int n) {
    for (int i = 0; i < n; i++) {
      nums[i] = nums[i] << 10;
      nums[i] = nums[i] | nums[i + n];
    }

    int j = 2 * n - 1;

    for (int i = n - 1; i > -1; i--) {
      int y = nums[i] & ((1 << 10) - 1);
      int x = nums[i] >> 10;

      nums[j] = y;
      nums[j - 1] = x;
      j -= 2;
    }
    for (int num : nums) System.out.println(num);
    return nums;
  }

  public static int[] shuffle(int[] nums, int n) {
    if (nums.length == 0) return null;

    for (int i = 0; i < n; i++) {
      nums[i] = nums[i] << 10;
      nums[i] = nums[i] | nums[n + i];
    }

    int j = 2 * n - 1;
    for (int i = n - 1; i > -1; i--) {
      int y = nums[i] & ((1 << 10) - 1);
      int x = nums[i] >> 10;

      nums[j] = y;
      nums[j - 1] = x;
      j -= 2;
    }
    return nums;
  }

  public static void main(String[] args) {
    shuffleConstantSpace(new int[] {2, 5, 1, 3, 4, 7}, 3);
  }
}

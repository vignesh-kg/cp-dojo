import java.util.Arrays;

public class ShuffleArray {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().shuffle(new int[] { 2, 5, 1, 3, 4, 7 }, 3)));
  }
}

class Solution {
  public int[] shuffle(int[] nums, int n) {
    int[] res = new int[nums.length];
    int pos = 0;
    for (int i = 0; i < nums.length / 2; ++i) {
      res[pos] = nums[i];
      res[++pos] = nums[i + n];
      ++pos;
    }
    return res;
  }
}
import java.util.Arrays;

public class ConcatOfArray {
  public static void main(String[] args){
    Solution s = new Solution();
    System.out.println(Arrays.toString(s.getConcatenation(new int[]{1,2,3})));
  }
}

class Solution {
  public int[] getConcatenation(int[] nums) {
    int[] res = Arrays.copyOf(nums, 2*nums.length);
    System.arraycopy(nums, 0, res, nums.length, nums.length);
    return res;
  }
}
import java.util.Arrays;

public class NumbersWithEvenDigits {
  public static void main(String[] args) {
    int[] input = new int[]{12,345,2,6,7896};
    Solution s = new Solution();
    System.out.println(s.findNumbers(input));
  }
}

class Solution {
  public int findNumbers(int[] nums) {
    return (int) Arrays.stream(nums).filter(num -> {
      int count = 0;
      for(;num != 0; num /= 10){
        ++count;
      }
      return count % 2 == 0;
    }).count();
  }
}
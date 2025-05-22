package cp.dojo.solution.arrays;

public class LongestSubArrayOnesAfterDeletingOneElement {
  public static void main(String[] args){
    LongestSubArrayOnesAfterDeletingOneElement s = new LongestSubArrayOnesAfterDeletingOneElement();
    System.out.println(s.longestSubarray(new int[]{1,1,0,1}));
  }

  public int longestSubarray(int[] nums) {
    int prevOnes = 0, curOnes = 0;
    int longestLen = 0;
    for (int num : nums) {
      if (num == 1) {
        curOnes += 1;
      } else {
        longestLen = Math.max(longestLen, prevOnes + curOnes);
        prevOnes = curOnes;
        curOnes = 0;
      }
    }
    longestLen = Math.max(longestLen, prevOnes + curOnes);
    return longestLen == nums.length ? longestLen-1 : longestLen;
  }
}

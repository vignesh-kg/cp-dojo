package cp.dojo.solution.arrays;

public class MaxConsecutiveOnesIII {
  public static void main(String[] args){
    MaxConsecutiveOnesIII s = new MaxConsecutiveOnesIII();
    System.out.println(s.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
  }

  public int longestOnes(int[] nums, int k) {
    int start = 0, end = 0;
    int maxOnes = 0;
    while(end < nums.length){
      if(nums[end] == 1){
        end += 1;
      } else {
        if(k > 0){
          k -= 1;
          end += 1;
        } else {
          if(nums[start] == 0){
            k += 1;
          }
          start += 1;
        }
      }
      maxOnes = Math.max(maxOnes, end-start);
    }
    return maxOnes;
  }
}

package cp.dojo.solution.arrays;

public class MaxAvgSubArray {
  public static void main(String[] args){
    MaxAvgSubArray s = new MaxAvgSubArray();
    System.out.println(s.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
  }

  public double findMaxAverage(int[] nums, int k) {
    int maxSum = 0;
    for(int i = 0; i < k; i += 1){
      maxSum += nums[i];
    }
    int curSum = maxSum;
    for(int i = k; i < nums.length; i += 1){
      curSum += nums[i] - nums[i-k];
      if(maxSum < curSum){
        maxSum = curSum;
      }
    }
    return (double) maxSum/k;
  }
}

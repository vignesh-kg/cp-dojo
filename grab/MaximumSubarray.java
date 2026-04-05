package grab;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarray {
    public static void main(String[] args){
        MaximumSubarray s = new MaximumSubarray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(s.maxSubArray(nums));
        System.out.println(s.maxSubArrayIntegers(nums));
    }

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for(int n : nums){
            sum += n;
            if(maxSum < sum) maxSum = sum;
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }

    public List<Integer> maxSubArrayIntegers(int[] nums){
        int maxSum = Integer.MIN_VALUE, sum = 0;
        List<Integer> res = new ArrayList<>(), temp = new ArrayList<>();
        for(int n : nums){
            sum += n;
            temp.add(n);
            if(maxSum < sum) {
                maxSum = sum;
                res = new ArrayList<>(temp);
            }
            if(sum < 0){
                sum = 0;
                temp = new ArrayList<>();
            }
        }
        return res;
    }
}

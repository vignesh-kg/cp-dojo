import java.util.stream.IntStream;

public class MinimumCostSubArray1 {
    static{
        new MinimumCostSubArray1().minimumCost(new int[]{1,2,3});
    }

    public int minimumCost(int[] nums) {
        int[] min = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        IntStream.range(1, nums.length).forEach(i -> {
            if(nums[i] < min[0]){
                min[1] = min[0];
                min[0] = nums[i];
            } else if(nums[i] < min[1]){
                min[1] = nums[i];
            }
        });
        return nums[0] + min[0] + min[1];
    }

    public static void main(String[] args){
        MinimumCostSubArray1 s = new MinimumCostSubArray1();
        System.out.println(s.minimumCost(new int[]{1,2,3,12}));
    }
}

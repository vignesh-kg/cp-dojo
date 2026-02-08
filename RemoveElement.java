import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0; i < nums.length; i += 1){
            if(nums[i] != val){
                nums[k] = nums[i];
                ++k; 
            }
        }
        return k;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,2,4,3};
        System.out.println(new RemoveElement().removeElement(nums, 3) + "\n" + Arrays.toString(nums));
    }
}

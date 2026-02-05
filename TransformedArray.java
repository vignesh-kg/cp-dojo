import java.util.Arrays;

public class TransformedArray{
	public static void main(String[] args){
		System.out.println(Arrays.toString(new TransformedArray().constructTransformedArray(new int[]{3, -2, 1, 1})));
	}
	
	public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
		int[] res = new int[n];
		for(int i = 0; i < n; ++i){
			res[i] = nums[((i+nums[i])%n + n)%n];
		}
		return res;
    }
}
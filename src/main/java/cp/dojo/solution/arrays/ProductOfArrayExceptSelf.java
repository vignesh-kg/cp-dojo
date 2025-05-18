package cp.dojo.solution.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
  public static void main(String[] args){
    ProductOfArrayExceptSelf s = new ProductOfArrayExceptSelf();
    System.out.println(Arrays.toString(s.productExceptSelf(new int[]{1,2,3,4})));
  }

  public int[] productExceptSelf(int[] nums) {
    int[] res = new int[nums.length];
    res[0] = 1;
    //Calculate prefix product
    for(int i = 1; i < nums.length; i += 1){
      res[i] = res[i-1] * nums[i-1];
    }
    int product = 1;
    for(int i = nums.length-1; i >= 0; i -= 1 ){
      res[i] *= product;
      product *= nums[i];
    }
    return res;
  }
}

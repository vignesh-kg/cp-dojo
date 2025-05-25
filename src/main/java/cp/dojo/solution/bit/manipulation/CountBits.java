package cp.dojo.solution.bit.manipulation;

import java.util.Arrays;

public class CountBits {
  public int[] countBits(int n) {
    int[] ans = new int[n+1];
    ans[0] = 0;
    for(int i = 1; i <= n; i += 1){
      ans[i] = ans[i/2] + (i%2);
    }
    return ans;
  }

  public static void main(String[] args){
    CountBits s = new CountBits();
    System.out.println(Arrays.toString(s.countBits(5)));
  }
}

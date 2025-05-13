public class UniquePaths {
  public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePathsUsingRecursion(3, 7));
        System.out.println(s.uniquePathsUsingRecursion(3, 2));
    }
}

class Solution {
    public int uniquePathsUsingRecursion(int m, int n) {
        return 1 + recursive(0, 0, m-1, n-1);
    }

    private int recursive(int i, int j, int m, int n){
      if(i >= m || j >= n){
        return 0;
      }

      return 1 + recursive(i+1, j, m, n) + recursive(i, j+1, m, n);
    }
}
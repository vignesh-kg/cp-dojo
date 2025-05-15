public class EditDistance {
  public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.minDistance("horse", "ros"));
      System.out.println(s.minDistance("", "a"));
  }
}

class Solution {
    public int minDistance(String word1, String word2) {
      char[] src = word1.toCharArray(), target = word2.toCharArray();
      if(src.length < target.length){
        char[] temp = src;
        src = target;
        target = temp;
      }
      int[] prev = new int[target.length+1];
      for(int i = 0; i < target.length; i += 1){
        prev[i] = i;
      }
      int[] cur = new int[target.length+1];

      for(int i = 1; i <= src.length; i += 1){
        cur[0] = i;
        for(int j = 1; j <= target.length; j += 1){
          if(src[i-1] == target[j-1]){
            cur[j] = prev[j-1];
          } else {
            // If the characters don't match, take the minimum of three possibilities:
            // 1. Replace the character in S1 with the character in S2 (diagonal). f(i-1, j-1)
            // 2. Delete the character in S1 (left). f(i-1, j)
            // 3. Insert the character from S2 into S1 (up). f(i, j-1)
            cur[j] = 1 + Math.min(prev[j], Math.min(prev[j-1], cur[j-1]));
          }
        }
        prev = cur.clone();
      }
      return cur[target.length];
    }
}
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonSubsequenceUsingRecursion("abcde", "ace"));
        System.out.println(s.longestCommonSubsequence("abcde", "ace"));
        System.out.println(s.longestCommonSubsequence("abcba", "abcbcba"));
        System.out.println(s.longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }
}

class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
      if(text1.length() < text2.length()){
        String temp = text1;
        text1 = text2;
        text2 = temp;
      }
      char[] str1 = text1.toCharArray(), str2 = text2.toCharArray();
      //using smaller string length as longest common subsequence cannot exceed smallest String
      int[] prev = new int[str2.length+1]; 
      //Base case
      prev[0] = 0;

      for(int i = 1; i <= str1.length; i += 1){
        int[] cur = new int[str2.length+1];
        for(int j = 1; j <= str2.length; j += 1){
          if(str1[i-1] == str2[j-1]){
            cur[j] = 1 + prev[j-1];
          } else {
            cur[j] = Math.max(prev[j], cur[j-1]);
          }
        }
        prev = cur;
      }
      return prev[str2.length];
    }

    public int longestCommonSubsequenceUsingRecursion(String text1, String text2) {
        return recursive(text1.length() - 1, text2.length() - 1, text1.toCharArray(), text2.toCharArray());
    }

    private int recursive(int index1, int index2, char[] text1, char[] text2) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (text1[index1] == text2[index2]) {
            return 1 + recursive(index1 - 1, index2 - 1, text1, text2);
        }

        return Math.max(recursive(index1 - 1, index2, text1, text2), recursive(index1, index2 - 1, text1, text2));
    }
}

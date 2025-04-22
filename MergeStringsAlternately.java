import java.util.Scanner;

public class MergeStringsAlternately {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution s = new Solution();
    System.out.println(s.mergeAlternately(sc.nextLine(), sc.nextLine()));
  }
}

class Solution {
  public String mergeAlternately(String word1, String word2) {

    char[] word1Arr = word1.toCharArray(), word2Arr = word2.toCharArray();
    int l1 = word1Arr.length, l2 = word2Arr.length;
    char[] mergedString = new char[l1 + l2];

    int maxLen = l1 > l2 ? l1 : l2;
    int j = 0;
    for (int i = 0; i < maxLen; ++i) {
      if (i < l1) {
        mergedString[j] = word1Arr[i];
        ++j;
      }
      if (i < l2) {
        mergedString[j] = word2Arr[i];
        ++j;
      }
    }
    return String.valueOf(mergedString);
  }
}
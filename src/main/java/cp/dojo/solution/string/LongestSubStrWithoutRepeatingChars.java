package cp.dojo.solution.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStrWithoutRepeatingChars {
  public static void main(String[] args) {
    LongestSubStrWithoutRepeatingChars s = new LongestSubStrWithoutRepeatingChars();
    System.out.println(s.lengthOfLongestSubstring("abcabcdbb"));
    System.out.println(s.lengthOfLongestSubstring("pwwkew"));
  }

  public int lengthOfLongestSubstring(String s) {
    if(s.length() == 0 || s.length() == 1){
      return s.length();
    }
    int left = 0, maxLen = 0;
    char[] sArr = s.toCharArray();
    Set<Character> seen = new HashSet<>();
    for (int right = 0; right < sArr.length; ++right) {
      if(seen.contains(sArr[right])){
        while(left < right && seen.contains(sArr[right])){
          seen.remove(sArr[left]);
          ++left;
        }
      }

      maxLen = Math.max(maxLen, (right - left + 1));
      seen.add(sArr[right]);
    }
    return maxLen;
  }
}

package strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {
  public static void main(String[] args){
    LongestSubstringWithoutRepeatingChars s = new LongestSubstringWithoutRepeatingChars();
    System.out.println(s.lengthOfLongestSubstring("au"));
    System.out.println(s.lengthOfLongestSubstring("pwwkew"));
  }

  public int lengthOfLongestSubstring(String s) {
    if(s.length() <= 1){
      return s.length();
    }
    char[] sArr = s.toCharArray();
    int left = 0, right = 0;
    int maxLen = 0;
    Set<Character> seen = new HashSet<>();
    while(right < sArr.length){
      if(!seen.contains(sArr[right])){
        seen.add(sArr[right++]);
      } else {
        maxLen = Math.max(maxLen, right-left);
        seen.remove(sArr[left++]);
      }
    }
    maxLen = Math.max(maxLen, right-left);
    return left == right ? 1 : maxLen;
  }
}

public class ReverseVowelsOfString{
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.reverseVowels("IceCreAm"));
  }
}

class Solution {
  public String reverseVowels(String s) {
    char[] input = s.toCharArray();
    int l = 0, r = input.length-1;
    while( l < r){
      boolean lIsVowel = isVowel(input[l]), rIsVowel = isVowel(input[r]);
      if(lIsVowel && rIsVowel){
        char temp = input[l];
        input[l] = input[r];
        input[r] = temp;
        l += 1;
        r -= 1;
      } else if(!lIsVowel && !rIsVowel){
        l += 1;
        r -= 1;
      } else if(lIsVowel && !rIsVowel){
        r -= 1;
      } else {
        l += 1;
      }
    }
    return String.valueOf(input);
  }

  private boolean isVowel(char ch){
    return switch(ch){
      case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
      default -> false;
    };
  }
}
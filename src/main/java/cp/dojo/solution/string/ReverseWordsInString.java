package cp.dojo.solution.string;

import java.util.Arrays;

public class ReverseWordsInString {
  public static void main(String[] args){
    ReverseWordsInString s = new ReverseWordsInString();
    System.out.println(s.reverseWords("the sky is blue "));
  }

  public String reverseWords(String s) {
    StringBuilder sb = new StringBuilder();
    String[] strArr = s.split("\\s+");
    for(int i = strArr.length-1; i >= 0; i -= 1){
      if(!strArr[i].isEmpty()){
        sb.append(strArr[i]).append(" ");
      }
    }
    return sb.toString().trim();
  }
}

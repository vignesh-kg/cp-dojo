package cp.dojo.solution.string;

public class IsSubsequence {
  public static void main(String[] args){
    IsSubsequence s = new IsSubsequence();
    System.out.println(s.isSubsequence("abc", "ahbgdc"));
  }

  public boolean isSubsequence(String s, String t) {
    char[] sArr = s.toCharArray(), tArr = t.toCharArray();
    int i = 0, j = 0;
    while(j < tArr.length && i < sArr.length){
      if(sArr[i] == tArr[j]){
        i += 1;
      }
      j += 1;
    }
    return i == sArr.length;
  }
}

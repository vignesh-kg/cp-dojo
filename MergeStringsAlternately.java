public class MergeStringsAlternately {
  public static void main(String[] args) {
    MergeStringsAlternately s = new MergeStringsAlternately();
    System.out.println(s.mergeAlternately("abc", "pqrs"));
  }

  public String mergeAlternately(String word1, String word2) {
    char[] w1 = word1.toCharArray();
    char[] w2 = word2.toCharArray();
    StringBuilder result = new StringBuilder();
    int i = 0, j = 0;
    while(i < w1.length || j < w2.length){
      if(i < w1.length){
        result.append(w1[i]);
        i += 1;
      }

      if(j < w2.length){
        result.append(w2[j]);
        j += 1;
      }
    }
    return result.toString();
  }
}

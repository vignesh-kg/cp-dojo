package cp.dojo.solution.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateBracketPairs {
  public static void main(String[] args) {
    EvaluateBracketPairs s = new EvaluateBracketPairs();
    System.out.println(s.evaluate("(name)is(age)yearsold", List.of(List.of("name", "bob"), List.of("age", "two"))));
  }

  public String evaluate(String s, List<List<String>> knowledge) {
    Map<String, String> dict = new HashMap<>();
    for(List<String> knowl : knowledge){
      dict.put(knowl.get(0), knowl.get(1));
    }
    StringBuilder res = new StringBuilder();
    StringBuilder curKey = new StringBuilder();
    boolean bracketFound = false;
    for(char ch : s.toCharArray()){
      if(ch == '('){
        bracketFound = true;
        curKey.setLength(0);
      } else if (ch == ')'){
        res.append(dict.getOrDefault(curKey.toString(), "?"));
        bracketFound = false;
      } else if(bracketFound){
        curKey.append(ch);
      } else {
        res.append(ch);
      }
    }
    return res.toString();
  }
}

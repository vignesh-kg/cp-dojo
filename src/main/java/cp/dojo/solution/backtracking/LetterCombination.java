package cp.dojo.solution.backtracking;

import java.util.List;
import java.util.ArrayList;

public class LetterCombination{
  /*
   * Input: digits = "23"
   * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
  */
  String[] combinations = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if(digits.isBlank()){
      return result;
    }
    backtrack(0, new StringBuilder(), result, digits.toCharArray());
    return result;
  }

  private void backtrack(int index, StringBuilder temp, List<String> result, char[] digits){
    if(index >= digits.length){
      result.add(temp.toString());
      return;
    }
    char[] combination = combinations[Character.getNumericValue(digits[index])].toCharArray(); // digit = 2 combination = [a,b,c]
    for(char ch : combination){
      temp.append(ch);
      backtrack(index+1, temp, result, digits);
      temp.deleteCharAt(temp.length()-1);
    }
  }
  
  public static void main(String[] args){
    LetterCombination s = new LetterCombination();
    System.out.println(s.letterCombinations("23"));
  }
}

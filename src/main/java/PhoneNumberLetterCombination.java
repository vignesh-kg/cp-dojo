import java.util.List;
import java.util.ArrayList;

public class PhoneNumberLetterCombination{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.letterCombinations("23"));
	}
}

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
		if(digits.isEmpty()){
			return result;
		}
		backtrack(0, result, new StringBuilder(), digits.toCharArray());
		return result;
    }
	String[] keys = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	private void backtrack(int index, List<String> result, StringBuilder temp, char[] digits){
		if(index == digits.length){
			result.add(temp.toString());
			return;
		}
		
		char[] combination = keys[Character.getNumericValue(digits[index])].toCharArray();
		for(char ch : combination){
			temp.append(ch);
			backtrack(index+1, result, temp, digits);
			temp.deleteCharAt(temp.length()-1);
		}
	}
}

/*
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
*/

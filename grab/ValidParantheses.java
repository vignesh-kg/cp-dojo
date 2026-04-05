package grab;

import java.util.Stack;

public class ValidParantheses {
    public static void main(String[] args) {
        System.out.println(new ValidParantheses().isValid("{]"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            switch(ch){
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if(stack.isEmpty() || ch != stack.pop()) return false;
            }
        }
        return stack.isEmpty();
    }
}

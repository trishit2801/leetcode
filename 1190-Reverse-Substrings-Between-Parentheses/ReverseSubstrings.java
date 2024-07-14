import java.util.*;
class ReverseSubstrings {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push(s.charAt(i));
            else if(s.charAt(i) == ')'){
                StringBuilder sb = new StringBuilder();
                while(stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
                int j=0;
                while(j < sb.length()){
                    stack.push(sb.charAt(j));
                    j++;
                }
            }
            else
                stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        String res = sb.reverse().toString();
        return res;
    }
}
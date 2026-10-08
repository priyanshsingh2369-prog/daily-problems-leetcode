import java.util.*;

class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {

            if (c == '(') {
                
                if (!stack.isEmpty()) {
                    ans.append(c);
                }
                stack.push(c);

            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    ans.append(c);
                }
            }
        }

        return ans.toString();
    }
}
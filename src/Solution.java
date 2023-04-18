import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        String lefts = "{[(";
        // String rights = "}])";
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lefts.contains(String.valueOf(c))) stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char poped = stack.pop();
                poped = switch (poped){
                    case'[' -> ']';
                    case'{' -> '}';
                    default -> ')';
                };
                if (poped != c) return false;
            }
        }
        return stack.isEmpty();
    }
}

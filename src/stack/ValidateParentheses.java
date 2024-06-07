package stack;

import java.util.Stack;

public class ValidateParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{([{()}])}"));
        System.out.println(isValid("{([()}])}"));
        System.out.println(isValid("{({()}])}"));
        System.out.println(isValid("{({}[])}"));
        System.out.println(isValid("{([)}"));

        System.out.println();

        System.out.println(isValid("]]"));
        System.out.println(isValid("(("));
        System.out.println(isValid("[["));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if(s.length() % 2 != 0)
            return false;

        int stackSize;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(' ) {
                stack.push(s.charAt(i));
                if (i+1 == s.length())
                    return false;
                continue;
            }
            if(stack.empty()) return false;

            switch (stack.pop()) {
                case '{': 
                    if (s.charAt(i) != '}')
                    return false;
                    break;
                case '[':
                    if (s.charAt(i) != ']')
                    return false;
                    break;
                case '(':
                    if (s.charAt(i) != ')')
                    return false;
                    break;
                default:
                    break;
            }
        }
        return true;
    }

}

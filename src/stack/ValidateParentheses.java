package stack;

import java.util.Stack;

public class ValidateParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{([{()}])}"));
        System.out.println(isValid("{([()}])}"));
        System.out.println(isValid("{({()}])}"));
        System.out.println(isValid("{({}[])}"));
        System.out.println(isValid("{([)}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if(s.length() % 2 != 0)
            return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(' ) {
                stack.push(s.charAt(i));
                continue;
            }

            char stackCheck = stack.pop();
            switch (stackCheck) {
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

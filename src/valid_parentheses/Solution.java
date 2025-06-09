package valid_parentheses;

import java.util.Stack;

public class Solution {
    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     * An input string is valid if:
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     */

    public static boolean isValidThree(String s) {
        Stack<Character> chars = new Stack<>();
        char[] c = s.toCharArray();
        int valid = 0;
        if (c[0] == ')' || c[0] == '}' || c[0] == ']')
            return false;

        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(' || c[i] == '{' || c[i] == '[') {
                chars.push(c[i]);
                valid++;
            } else if ((valid != 0) &&
                    (c[i] == (char) (chars.peek() + 1) || c[i] == (char) (chars.peek() + 2))) {
                chars.pop();
                valid--;
            } else {
                return false;
            }

        }
        return valid == 0;

    }

    public static void main(String[] args) {
        System.out.println(isValidThree("([)"));
    }
}

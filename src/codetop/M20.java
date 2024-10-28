package codetop;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class M20 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stk.push(c);
            } else {
                if (stk.empty() || stk.peek() != map.get(c)) {
                    return false;
                }
                stk.pop();
            }
        }
        return stk.isEmpty();
    }
}

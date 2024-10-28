package codetop;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class M227 {
    Deque<Integer> numStk = new LinkedList<>();
    Deque<Character> opStk = new LinkedList<>();
    Map<Character, Integer> map = new HashMap<>();

    void compute() {
        int b = numStk.poll();
        int a = numStk.poll();
        char op = opStk.poll();
        if (op == '+') {
            numStk.push(a + b);
        } else if (op == '-') {
            numStk.push(a - b);
        } else if (op == '*') {
            numStk.push(a * b);
        } else {
            numStk.push(a / b);
        }
    }

    public int calculate(String s) {
        map.put('+', 0);
        map.put('-', 0);
        map.put('*', 1);
        map.put('/', 1);
        numStk.push(0);
        s = s.replace(" ", "");
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int num = 0;
            if (Character.isDigit(s.charAt(i))) {
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }
                numStk.push(num);
                i--;
            } else if (s.charAt(i) == '(') {
                opStk.push('(');
            } else if (s.charAt(i) == ')') {
                while (opStk.peek() != '(') {
                    compute();
                }
                opStk.poll();
            } else {
                if (i > 0 && (s.charAt(i - 1) == '(')) {
                    numStk.push(0);
                }
                while (!opStk.isEmpty() && map.get(opStk.peek()) >= map.get(s.charAt(i))) {
                    compute();
                }
                opStk.push(s.charAt(i));
            }
        }
        while (!opStk.isEmpty()) {
            compute();
        }
        return numStk.peek();
//        Deque<Integer> stack = new LinkedList<>();
//        int num = 0;
//        char preSign = '+';
//        int n = s.length();
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isDigit(s.charAt(i))) {
//                num = num * 10 + s.charAt(i) - '0';
//            }
//            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
//                if (preSign == '+') stack.push(num);
//                else if (preSign == '-') stack.push(-num);
//                else if (preSign == '*') stack.push(stack.pop() * num);
//                else stack.push(stack.pop() / num);
//                preSign = s.charAt(i);
//                num = 0;
//            }
//        }
//        int ans = 0;
//        while (!stack.isEmpty()) {
//            ans += stack.pop();
//        }
//        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new M227().calculate("1*2-(-3/4+5*6-7*8)+9/10"));
    }
}
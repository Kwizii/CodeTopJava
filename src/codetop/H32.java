package codetop;

class H32 {
    public int longestValidParentheses(String s) {
        int ans = 0;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (right > left) {
                left = right = 0;
            } else if (left == right) {
                ans = Math.max(ans, left + right);
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left > right) {
                left = right = 0;
            } else if (left == right) {
                ans = Math.max(ans, left + right);
            }
        }
        return ans;
//        Deque<Integer> stack = new LinkedList<>();
//        stack.push(-1);
//        int ans = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                stack.push(i);
//            } else {
//                stack.pop();
//                if (stack.isEmpty()) {
//                    stack.push(i);
//                } else {
//                    ans = Math.max(ans, i - stack.peek());
//                }
//            }
//        }
//        return ans;
    }
}
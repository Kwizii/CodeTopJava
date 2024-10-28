package codetop;

import java.util.ArrayList;
import java.util.List;

class M22 {
    void gen(String cur, int open, int close, int n, List<String> list) {
        if (open == n && close == n) {
            list.add(cur);
            return;
        }
        if (open < n) {
            gen(cur + "(", open + 1, close, n, list);
        }
        if (close < open) {
            gen(cur + ")", open, close + 1, n, list);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        gen("", 0, 0, n, ans);
        return ans;
    }

    public static void main(String[] args) {
        new M22().generateParenthesis(1);
    }
}
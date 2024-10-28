package codetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class M93 {
    List<String> ans = new ArrayList<>();

    public void backtrack(String s, int idx, List<String> path) {
        if (path.size() == 4) {
            if (idx == s.length()) {
                ans.add(path.get(0) + "." + path.get(1) + "." + path.get(2) + "." + path.get(3));
            }
            return;
        }
        for (int len = 1; len <= 3; len++) {
            int j = idx + len;
            if (j > s.length()) {
                break;
            }
            String substr = s.substring(idx, j);
            if (substr.length() > 1 && substr.charAt(0) == '0') {
                break;
            }
            if (Integer.parseInt(substr) > 255) {
                break;
            }
            path.add(substr);
            backtrack(s, j, path);
            path.remove(path.size() - 1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, new LinkedList<>());
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new M93().restoreIpAddresses("25525511135"));
    }
}
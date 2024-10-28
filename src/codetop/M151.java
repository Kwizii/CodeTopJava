package codetop;

import java.util.Arrays;
import java.util.Collections;

class M151 {
    public String reverseWords(String s) {
        int l = 0, r = s.length() - 1;
        while (s.charAt(l) == ' ') l++;
        while (s.charAt(r) == ' ') r--;
        String[] strings = s.substring(l, r + 1).split("\\s+");
        Collections.reverse(Arrays.asList(strings));
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            ans.append(strings[i]);
            if (i != strings.length - 1) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new M151().reverseWords("  hello world  "));
    }
}
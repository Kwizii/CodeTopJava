package codetop;

class M14 {
    public String longestCommonPrefix(String[] strs) {
        int len = 0;
        while (true) {
            boolean flag = true;
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() <= len || (i > 0 && strs[i].charAt(len) != strs[i - 1].charAt(len))) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            len++;
        }
        return strs[0].substring(0, len);
    }
}
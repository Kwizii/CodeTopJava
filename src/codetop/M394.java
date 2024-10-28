package codetop;

class M394 {
    public String decodeString(String s) {
        StringBuilder cur = new StringBuilder();
        char c;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder numStr = new StringBuilder();
            while (Character.isDigit(c = s.charAt(i))) {
                numStr.append(c);
                i++;
            }
            if (c == '[') {
                int startIdx = ++i;
                int leftCnt = 1;
                while (leftCnt != 0) {
                    if (s.charAt(i + 1) == '[') {
                        leftCnt++;
                    } else if (s.charAt(i + 1) == ']') {
                        leftCnt--;
                    }
                    i++;
                }
                int repeats = Integer.parseInt(numStr.toString());
                String tmp = decodeString(s.substring(startIdx, i));
                while (repeats-- > 0) {
                    cur.append(tmp);
                }
            } else if (Character.isAlphabetic(c)) {
                cur.append(c);
            }
        }
        return cur.toString();
    }

    public static void main(String[] args) {
        new M394().decodeString("3[a]2[bc]");
    }
}
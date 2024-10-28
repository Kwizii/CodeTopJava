package codetop;

class M8 {
    public int myAtoi(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') i++;
        boolean pos = true;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            pos = s.charAt(i) == '+';
            i++;
        }
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        long num = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i)) &&
                (num >= Integer.MIN_VALUE && num <= Integer.MAX_VALUE)) {
            num *= 10;
            num += s.charAt(i) - '0';
            i++;
        }
        if (!pos) {
            num = -num;
        }
        if (num >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) num;
    }

    public static void main(String[] args) {
        new M8().myAtoi("");
    }
}
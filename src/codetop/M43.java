package codetop;

class M43 {
    public String multiplySingle(String num, Character x) {
        if (x == '0') {
            return "0";
        }
        int carry = 0;
        int nx = x - '0';
        StringBuilder ans = new StringBuilder();
        int i = num.length() - 1;
        while (i >= 0 || carry != 0) {
            int cur = i >= 0 ? num.charAt(i--) - '0' : 0;
            int tmp = (cur * nx) + carry;
            carry = tmp / 10;
            ans.append(tmp % 10);
        }
        return ans.toString();
    }

    public String add(String num1, String num2) {
        int i = 0, j = 0;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while (i < num1.length() || j < num2.length() || carry != 0) {
            int a = i < num1.length() ? num1.charAt(i++) - '0' : 0;
            int b = j < num2.length() ? num2.charAt(j++) - '0' : 0;
            int tmp = a + b + carry;
            carry = tmp / 10;
            ans.append(tmp % 10);
        }
        return ans.toString();
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder preZero = new StringBuilder();
        String ans = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            char c = num2.charAt(i);
            String tmp = multiplySingle(num1, c);
            ans = add(ans, preZero + tmp);
            preZero.append("0");
        }
        return new StringBuilder(ans).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new M43().multiply("123", "456"));
    }
}
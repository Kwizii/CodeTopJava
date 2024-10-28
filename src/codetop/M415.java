package codetop;

class M415 {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int a = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int x = carry + a + b;
            carry = x / 10;
            sb.append(x % 10);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new M415().addStrings("456", "77"));
    }
}
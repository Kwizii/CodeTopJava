package codetop;

public class M2957 {
    public int removeAlmostEqualCharacters(String word) {
        int cnt = 0;
        for (int i = 1; i < word.length(); i++) {
            if (Math.abs(word.charAt(i) - word.charAt(i - 1)) <= 1) {
                cnt++;
                i++;
            }
        }
        return cnt;
    }
}

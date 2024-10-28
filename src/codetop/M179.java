package codetop;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class M179 {
    public String largestNumber(int[] nums) {
        List<Integer> collect = Arrays.stream(nums).boxed().sorted((x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (sx * y + x - sy * x - y);
        }).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (Integer s : collect) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new M179().largestNumber(new int[]{34323, 3432});
    }
}
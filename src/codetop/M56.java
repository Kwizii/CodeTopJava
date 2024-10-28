package codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class M56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> ans = new ArrayList<>();
        int[] curInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= curInterval[1]) {
                curInterval[1] = Math.max(intervals[i][1], curInterval[1]);
            } else {
                ans.add(curInterval);
                curInterval = intervals[i];
            }
        }
        ans.add(curInterval);
        return ans.toArray(new int[ans.size()][2]);
    }
}

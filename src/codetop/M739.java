package codetop;

import java.util.Deque;
import java.util.LinkedList;

class M739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> dq = new LinkedList<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && temperatures[dq.peek()] < temperatures[i]) {
                Integer top = dq.poll();
                ans[top] = i - top;
            }
            dq.push(i);
        }
        return ans;
    }
}
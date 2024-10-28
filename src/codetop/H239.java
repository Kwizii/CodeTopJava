package codetop;

import java.util.PriorityQueue;

class H239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0, r = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1], o1[1]));
        int[] ans = new int[nums.length - k + 1];
        while (l <= r && r < nums.length) {
            int len = r - l + 1;
            pq.offer(new int[]{r, nums[r]});
            while (pq.peek()[0] < l) {
                pq.poll();
            }
            ans[l] = pq.peek()[1];
            if (len == k) {
                l++;
            }
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        new H239().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
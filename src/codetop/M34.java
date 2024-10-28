package codetop;

class M34 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                int a = mid, b = mid;
                while (a > 0 && nums[a - 1] == target) {
                    a--;
                }
                while (b < nums.length - 1 && nums[b + 1] == target) {
                    b++;
                }
                return new int[]{a, b};
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
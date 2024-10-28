package codetop;

public class M33 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[0]) {
                // mid左侧严格递增
                if (target >= nums[0] && target < nums[mid]) {
                    // target在左侧范围
                    r = mid - 1;
                } else {
                    // target在右侧范围
                    l = mid + 1;
                }
            } else {
                // mid右侧严格递增
                if (target <= nums[nums.length - 1] && target > nums[mid]) {
                    // target在右侧范围
                    l = mid + 1;
                } else {
                    // target在左侧范围
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new M33().search(new int[]{3, 1}, 3));
    }
}

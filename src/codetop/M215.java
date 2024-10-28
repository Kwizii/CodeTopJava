package codetop;

public class M215 {
    void qsort(int[] nums, int l, int r) {
        if (l >= r) return;
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] > x);
            do j--; while (nums[j] < x);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        qsort(nums, l, i - 1);
        qsort(nums, j + 1, r);
    }

    public int findKthLargest(int[] nums, int k) {
        qsort(nums, 0, nums.length - 1);
        return nums[k - 1];
//        int n = (int) 2e4 + 1;
//        int[] a = new int[n];
//        for (int num : nums) {
//            a[num + (int) 1e4]++;
//        }
//        for (int i = a.length - 1; i >= 0; i--) {
//            while (a[i] > 0) {
//                if (k == 1) return (i - (int) 1e4);
//                else {
//                    a[i]--;
//                    k--;
//                }
//            }
//        }
//        return 0;
    }

    public static void main(String[] args) {
        new M215().findKthLargest(new int[]{3, 2, 5, 4, 5,}, 3);
    }
}

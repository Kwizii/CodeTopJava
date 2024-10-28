package codetop;

class M152 {
    public int maxProduct(int[] nums) {
        int product = 1, n = nums.length;
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            product *= nums[i];
            max = Math.max(max, product);
            if (nums[i] == 0) {
                product = 1;
            }
        }
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            product *= nums[i];
            max = Math.max(max, product);
            if (nums[i] == 0) {
                product = 1;
            }
        }
        return product;
//        int length = nums.length;
//        long[] maxF = new long[length];
//        long[] minF = new long[length];
//        for (int i = 0; i < length; i++) {
//            maxF[i] = nums[i];
//            minF[i] = nums[i];
//        }
//        for (int i = 1; i < length; i++) {
//            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
//            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
//            if (minF[i] < Integer.MIN_VALUE) {
//                minF[i] = nums[i];
//            }
//        }
//        int ans = (int) maxF[0];
//        for (int i = 1; i < length; i++) {
//            ans = Math.max(ans, (int) maxF[i]);
//        }
//        return ans;
    }

    public static void main(String[] args) {
        new M152().maxProduct(new int[]{5, 6, -3, 4, -3});
    }
}
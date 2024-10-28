package codetop;

class M42 {
    public int trap(int[] height) {
        int[] lMax = new int[height.length];
        int[] rMax = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            lMax[i] = Math.max(lMax[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], height[i + 1]);
        }
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            ans += Math.max(Math.min(lMax[i], rMax[i]) - height[i], 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        new M42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }
}
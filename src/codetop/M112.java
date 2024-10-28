package codetop;

import structs.TreeNode;

class M112 {
    int curSum = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        curSum += root.val;
        if (root.left == null && root.right == null && curSum == targetSum) {
            return true;
        }
        boolean r = hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
        curSum -= root.val;
        return r;
    }
}
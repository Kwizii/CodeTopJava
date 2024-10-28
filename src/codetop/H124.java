package codetop;

import structs.TreeNode;

class H124 {
    int maxSum = Integer.MIN_VALUE;

    public int maxGain(TreeNode node) {
        if (node == null) return 0;
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        int sum = node.val + leftGain + rightGain;
        maxSum = Math.max(sum, maxSum);
        return node.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
}
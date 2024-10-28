package codetop;

import structs.TreeNode;

class E110 {
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        return Math.max(left + 1, right + 1);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        if (Math.abs(lDepth - rDepth) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
package codetop;

import structs.TreeNode;

class M543 {
    int ans = 0;

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int l = depth(node.left);
        int r = depth(node.right);
        ans = Math.max(ans, l + r);
        return Math.max(l + 1, r + 1);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }
}
package codetop;

import structs.TreeNode;

class M236 {
    private TreeNode ans;

    public boolean traversal(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = traversal(root.left, p, q);
        boolean rson = traversal(root.right, p, q);
        if ((lson && rson) || ((root == p || root == q) && (lson || rson))) {
            ans = root;
            return true;
        }
        return lson || rson || root == p || root == q;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traversal(root, p, q);
        return ans;
    }
}
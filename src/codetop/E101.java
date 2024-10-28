package codetop;

import structs.TreeNode;

class E101 {
    public boolean equals(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a != null && b != null) {
            return a.val == b.val && equals(a.left, b.right) && equals(b.left, a.right);
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        return equals(root.left, root.right);
    }
}
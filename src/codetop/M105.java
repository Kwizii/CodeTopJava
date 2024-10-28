package codetop;

import structs.TreeNode;

class M105 {
    public TreeNode buildTree(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1 || l1 >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[l1]);
        int i = l2;
        for (; i < r2; i++) {
            if (inorder[i] == preorder[l1]) {
                break;
            }
        }
        root.left = buildTree(preorder, l1 + 1, l1 + i - l2, inorder, l2, i - 1);
        root.right = buildTree(preorder, l1 + i - l2 + 1, r1, inorder, i + 1, r2);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public static void main(String[] args) {

    }
}
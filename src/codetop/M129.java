package codetop;

import structs.TreeNode;

class M129 {
    int sum = 0;
    StringBuilder sb = new StringBuilder();

    public void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            sum += Integer.parseInt(sb.toString());
        }
        traversal(node.left);
        traversal(node.right);
        sb.deleteCharAt(sb.length() - 1);
    }

    public int sumNumbers(TreeNode root) {
        traversal(root);
        return sum;
    }

    public static void main(String[] args) {
//        new M129().sumNumbers()
    }
}
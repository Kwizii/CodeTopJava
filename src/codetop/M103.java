package codetop;

import structs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class M103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }
        boolean forward = true;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (forward) {
                    tmp.offerFirst(node.val);
                } else {
                    tmp.offerLast(node.val);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(tmp);
            forward = !forward;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
        new M103().zigzagLevelOrder(node);
    }
}
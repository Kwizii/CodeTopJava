package codetop;

import structs.TreeNode;

import java.util.ArrayList;
import java.util.List;

class M113 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void traversal(TreeNode node, int targetSum, int curSum) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        curSum += node.val;
        if (curSum == targetSum && node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path));
        }
        traversal(node.left, targetSum, curSum);
        traversal(node.right, targetSum, curSum);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traversal(root, targetSum, 0);
        return ans;
    }
}
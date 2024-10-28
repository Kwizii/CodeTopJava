package codetop;

import javafx.util.Pair;
import structs.TreeNode;

import java.util.ArrayList;
import java.util.List;

class M662 {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 1;
        List<Pair<TreeNode, Integer>> arr = new ArrayList<>();
        arr.add(new Pair<>(root, 1));
        while (!arr.isEmpty()) {
            List<Pair<TreeNode, Integer>> tmp = new ArrayList<>();
            for (Pair<TreeNode, Integer> pair : arr) {
                TreeNode node = pair.getKey();
                int idx = pair.getValue();
                if (node.left != null) {
                    tmp.add(new Pair<>(node.left, idx * 2));
                }
                if (node.right != null) {
                    tmp.add(new Pair<>(node.right, idx * 2 + 1));
                }
            }
            res = Math.max(res, arr.get(arr.size() - 1).getValue() - arr.get(0).getValue() + 1);
            arr = tmp;
        }
        return res;
    }
}
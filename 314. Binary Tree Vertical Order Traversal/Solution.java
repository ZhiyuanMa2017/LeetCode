import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Solution {
    Map<Integer, List<Integer>> map;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        map = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        map.put(0, new ArrayList<>());
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                TreeNode treeNode = cur.n;
                int index = cur.index;
                if (map.containsKey(index)) {
                    map.get(index).add(treeNode.val);
                } else {
                    map.put(index, new ArrayList<>());
                    map.get(index).add(treeNode.val);
                }
                if (treeNode.left != null) {
                    queue.offer(new Node(treeNode.left, index - 1));
                }
                if (treeNode.right != null) {
                    queue.offer(new Node(treeNode.right, index + 1));
                }
            }
        }


        for (Integer i : map.keySet()) {
            res.add(map.get(i));
        }
        return res;
    }

    class Node {
        TreeNode n;
        int index;

        Node(TreeNode node, int i) {
            n = node;
            index = i;
        }
    }


}

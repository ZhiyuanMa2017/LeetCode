import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;


class Solution {
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        PriorityQueue<NodePosition> priorityQueue = new PriorityQueue<>(
                new Comparator<NodePosition>() {
                    @Override
                    public int compare(NodePosition o1, NodePosition o2) {
                        if (o1.x != o2.x) {
                            return o1.x - o2.x;
                        } else if (o1.y != o2.y) {
                            return o2.y - o1.y;
                        } else {
                            return o1.val - o2.val;
                        }
                    }
                });
        helper(root, 0, 0, priorityQueue);
        int prev = Integer.MIN_VALUE;
        while (!priorityQueue.isEmpty()) {
            NodePosition nodePosition = priorityQueue.poll();
            if (nodePosition.x > prev) {
                List<Integer> l = new ArrayList<>();
                l.add(nodePosition.val);
                res.add(l);
            } else {
                List<Integer> l = res.get(res.size() - 1);
                l.add(nodePosition.val);
            }
            prev = nodePosition.x;
        }
        return res;
    }

    private static void helper(TreeNode node, int x, int y, PriorityQueue<NodePosition> pq) {
        if (node == null) {
            return;
        }
        pq.add(new NodePosition(x, y, node.val));
        helper(node.left, x - 1, y - 1, pq);
        helper(node.right, x + 1, y - 1, pq);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3, new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null, null), null));
        List<List<Integer>> res = verticalTraversal(a);
        System.out.println(Arrays.toString(res.toArray()));
    }

    class NodePosition {
        int x;
        int y;
        int val;

        NodePosition(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

}

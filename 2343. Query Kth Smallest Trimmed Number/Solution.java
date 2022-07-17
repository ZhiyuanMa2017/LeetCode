import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];
            res[i] = helper(nums, k, trim);
        }
        return res;
    }

    private int helper(String[] nums, int k, int trim) {
        int len = nums[0].length();
        Node[] nodes = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            String s = nums[i];
            String need = s.substring(len - trim);
            nodes[i] = new Node(need, i);
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (!o1.s.equals(o2.s)) {
                    return o1.s.compareTo(o2.s);
                }
                return o1.index - o2.index;
            }
        });
        return nodes[k - 1].index;
    }

    class Node {
        String s;
        int index;

        Node(String ss, int ii) {
            s = ss;
            index = ii;
        }
    }
}

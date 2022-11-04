import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val).append(",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    sb.append("null").append(",");
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        System.out.println(nodes.length);
        if (nodes[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < nodes.length - 1; i += 2) {
            TreeNode l = getNode(nodes[i]);
            TreeNode r = getNode(nodes[i + 1]);
            TreeNode node = queue.poll();
            while (node == null) {
                node = queue.poll();
            }
            node.left = l;
            node.right = r;
            queue.offer(l);
            queue.offer(r);
        }
        return root;
    }

    private TreeNode getNode(String s) {
        if (s.equals("null")) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(s));
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        TreeNode er = new TreeNode(2);
        TreeNode san = new TreeNode(3);
        TreeNode si = new TreeNode(4);
        TreeNode wu = new TreeNode(5);
        root.left = er;
        root.right = san;
        san.left = si;
        san.right = wu;
        System.out.println(codec.serialize(root));
        System.out.println(Arrays.toString("1,2,3,4,5,".split(",")));

    }


}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

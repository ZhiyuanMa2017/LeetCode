import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur == null) {
                    sb.append("null").append(",");
                } else {
                    int childNum = cur.children.size();
                    sb.append(cur.val).append("+").append(childNum).append(",");
                    for (int j = 0; j < childNum; j++) {
                        queue.offer(cur.children.get(j));
                    }
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] nodes = data.split(",");
        if (nodes[0].equals("null")) {
            return null;
        }
        Node root = new Node(Integer.parseInt(nodes[0].split("\\+")[0]));
        Queue<Node> queue = new LinkedList<>();
        int index = 0;
        int childIndex = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                String str = nodes[index];
                int childNum = Integer.parseInt(str.split("\\+")[1]);
                List<Node> children = new ArrayList<>();
                for (int j = 0; j < childNum; j++) {
                    Node child = new Node(Integer.parseInt(nodes[childIndex].split("\\+")[0]));
                    childIndex++;
                    children.add(child);
                    queue.offer(child);
                }
                node.children = children;
                index++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

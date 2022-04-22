import java.util.HashMap;
import java.util.Map;

class FileSystem {
    Node root;

    public FileSystem() {
        root = new Node(-1);
    }

    public boolean createPath(String path, int value) {
        String[] names = path.split("/");
        Node cur = root;
        for (int i = 1; i < names.length - 1; i++) {
            if (!cur.children.containsKey(names[i])) {
                if (i != names.length - 1) {
                    return false;
                }
            }
            cur = cur.children.get(names[i]);
        }
        if (cur.children.containsKey(names[names.length - 1])) {
            return false;
        } else {
            cur.children.put(names[names.length - 1], new Node(value));
            return true;
        }
    }

    public int get(String path) {
        String[] names = path.split("/");
        Node cur = root;
        for (int i = 1; i < names.length; i++) {
            if (!cur.children.containsKey(names[i])) {
                return -1;
            }
            cur = cur.children.get(names[i]);
        }
        return cur.val;
    }

    class Node {
        int val;
        Map<String, Node> children;

        Node(int v) {
            val = v;
            children = new HashMap<>();
        }

    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */

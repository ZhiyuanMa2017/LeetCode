import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    int n;
    Node sentinel;
    Node tail;
    Map<Integer, Node> map;

    LRUCache(int capacity) {
        n = capacity;
        map = new HashMap<>();
        sentinel = new Node(-1, -1);
        tail = new Node(-1, -1);
        sentinel.next = tail;
        tail.prev = sentinel;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            refresh(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            refresh(node);
        } else {
            if (map.size() == n) {
                Node toBeDel = tail.prev;
                map.remove(toBeDel.key);
                delete(toBeDel);
            }
            node = new Node(key, value);
            map.put(key, node);
            add(node);
        }
    }

    private void delete(Node node) {
        if (node.prev != null) {
            Node prev = node.prev;
            prev.next = node.next;
            node.next.prev = prev;
        }
    }

    private void add(Node node) {
        node.next = sentinel.next;
        node.prev = sentinel;
        sentinel.next.prev = node;
        sentinel.next = node;
    }

    private void refresh(Node node) {
        delete(node);
        add(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int max;

    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        map = new HashMap<>();
        max = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        delete(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            delete(node);
            add(node);
        } else {
            if (map.size() == max) {
                Node toBeDelete = tail.prev;
                delete(toBeDelete);
                map.remove(toBeDelete.key);
            }
            Node node = new Node(key, value);
            add(node);
            map.put(key, node);
        }
    }

    private void add(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    private void delete(Node node) {
        if (node == head || node == tail) {
            return;
        }
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

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
}

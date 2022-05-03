import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AllOne {
    class Node {
        Set<String> set;
        int count;
        Node prev;
        Node next;

        Node(int c) {
            count = c;
            set = new HashSet<>();
        }
    }

    Map<String, Node> stringToNode;
    Node head;
    Node tail;

    public AllOne() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        stringToNode = new HashMap<>();
    }

    private void clear(Node node) {
        if (node.set.size() == 0) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void inc(String key) {
        if (stringToNode.containsKey(key)) {
            Node node = stringToNode.get(key);
            node.set.remove(key);
            int count = node.count;
            Node next;
            if (node.next.count == count + 1) {
                next = node.next;
            } else {
                next = new Node(count + 1);
                Node right = node.next;
                node.next = next;
                next.prev = node;
                next.next = right;
                right.prev = next;
            }
            next.set.add(key);
            stringToNode.put(key, next);
            clear(node);
        } else {
            Node next;
            if (head.next.count == 1) {
                next = head.next;
            } else {
                next = new Node(1);
                next.prev = head;
                next.next = head.next;
                head.next.prev = next;
                head.next = next;
            }
            next.set.add(key);
            stringToNode.put(key, next);
        }
    }

    public void dec(String key) {
        Node node = stringToNode.get(key);
        node.set.remove(key);
        int count = node.count;
        if (node.count == 1) {
            stringToNode.remove(key);
            clear(node);
        } else {
            Node prev;
            if (node.prev.count == count - 1) {
                prev = node.prev;
            } else {
                prev = new Node(count - 1);
                prev.next = node;
                prev.prev = node.prev;
                node.prev.next = prev;
                node.prev = prev;
            }
            prev.set.add(key);
            stringToNode.put(key, prev);
            clear(node);
        }
    }

    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        } else {
            return tail.prev.set.iterator().next();
        }
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        } else {
            return head.next.set.iterator().next();
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */

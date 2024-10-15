import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class FirstUnique {
    Set<Integer> set;
    Node head;
    Node tail;
    Map<Integer, Node> map;

    public FirstUnique(int[] nums) {
        set = new HashSet<>();
        map = new HashMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            } else {
                if (map.containsKey(num)) {
                    remove(map.get(num));
                    set.add(num);
                } else {
                    map.put(num, insert(num));
                }
            }
        }
    }

    public int showFirstUnique() {
        if (head.next != tail) {
            return head.next.value;
        }
        return -1;
    }

    public void add(int value) {
        if (set.contains(value)) {
            return;
        } else {
            if (map.containsKey(value)) {
                remove(map.get(value));
                set.add(value);
            } else {
                map.put(value, insert(value));
            }
        }
    }

    Node insert(int v) {
        Node node = new Node(v);
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
        return node;
    }

    void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    class Node {
        int value;
        Node prev;
        Node next;

        Node(int v) {
            value = v;
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */

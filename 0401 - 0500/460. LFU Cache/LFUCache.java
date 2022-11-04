import java.util.HashMap;
import java.util.Map;

class LFUCache {

    int capacity;
    int size;
    int minCount;
    Map<Integer, DoubleLinkedList> countMap;
    Map<Integer, Node> nodeMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        minCount = 1;
        countMap = new HashMap<>();
        nodeMap = new HashMap<>();
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(0);
        lfuCache.put(0, 0);

        lfuCache.get(0);
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        int val = nodeMap.get(key).val;
        refresh(nodeMap.get(key));
        return val;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.val = value;
            refresh(node);
        } else {
            Node node = new Node(key, value);
            nodeMap.put(key, node);
            size++;
            DoubleLinkedList list = countMap.getOrDefault(1, new DoubleLinkedList());
            list.add(node);
            countMap.put(1, list);
            if (size > capacity) {
                DoubleLinkedList toRemoveList = countMap.get(minCount);
                Node toRemove = toRemoveList.removeFirst();
                if (toRemoveList.size == 0) {
                    countMap.remove(minCount);
                }
                nodeMap.remove(toRemove.key);
                size--;
            }
            minCount = 1;
        }
    }

    private void refresh(Node node) {
        DoubleLinkedList beforeList = countMap.get(node.cnt);
        beforeList.remove(node);
        if (beforeList.size == 0) {
            countMap.remove(node.cnt);
            if (minCount == node.cnt) {
                minCount++;
            }
        }
        node.cnt++;
        DoubleLinkedList afterList = countMap.getOrDefault(node.cnt, new DoubleLinkedList());
        afterList.add(node);
        countMap.put(node.cnt, afterList);
    }

    class Node {
        int key;
        int val;
        int cnt;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.cnt = 1;
        }
    }

    class DoubleLinkedList {
        Node head;
        Node tail;
        int size;

        public DoubleLinkedList() {
            size = 0;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        private void add(Node node) {
            tail.prev.next = node;
            node.prev = tail.prev;
            tail.prev = node;
            node.next = tail;
            size++;
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        private Node removeFirst() {
            if (size == 0) {
                return null;
            }
            Node node = head.next;
            remove(node);
            return node;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

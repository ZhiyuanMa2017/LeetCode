class MyHashMap {
    Node[] map;

    public MyHashMap() {
        map = new Node[10000];
    }

    public void put(int key, int value) {
        int index = key % 10000;
        if (map[index] == null) {
            map[index] = new Node(-1, -1);
        }
        Node pre = findPre(map[index], key);
        if (pre.next == null) {
            pre.next = new Node(key, value);
        } else {
            pre.next.val = value;
        }

    }

    public int get(int key) {
        int index = key % 10000;
        if (map[index] == null) {
            return -1;
        }
        Node pre = findPre(map[index], key);
        if (pre.next == null) {
            return -1;
        }
        return pre.next.val;
    }

    public void remove(int key) {
        int index = key % 10000;
        if (map[index] == null) {
            return;
        }
        Node pre = findPre(map[index], key);
        if (pre.next != null) {
            pre.next = pre.next.next;
        }
    }

    private Node findPre(Node root, int key) {
        Node pre = null;
        Node cur = root;
        while (cur != null && cur.key != key) {
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }


    class Node {
        int key;
        int val;
        Node next;

        Node(int k, int v) {
            key = k;
            val = v;
        }
    }
}

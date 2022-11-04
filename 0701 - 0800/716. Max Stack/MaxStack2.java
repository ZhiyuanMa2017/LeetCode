import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class MaxStack {
    class Node {
        int value;
        Node prev;
        Node next;

        Node(int v) {
            value = v;
        }
    }

    Node head;
    Node tail;
    TreeMap<Integer, List<Node>> treeMap;

    public MaxStack() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        treeMap = new TreeMap<>();
    }

    public void push(int x) {
        Node node = new Node(x);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        if (!treeMap.containsKey(x)) {
            treeMap.put(x, new ArrayList<>());
        }
        treeMap.get(x).add(node);
    }

    public int pop() {
        Node last = tail.prev;
        remove(last);
        List<Node> list = treeMap.get(last.value);
        list.remove(list.size() - 1);
        if (list.size() == 0) {
            treeMap.remove(last.value);
        }
        return last.value;
    }

    public int top() {
        return tail.prev.value;
    }

    public int peekMax() {
        return treeMap.lastKey();
    }

    public int popMax() {
        List<Node> maxList = treeMap.get(treeMap.lastKey());
        Node maxNode = maxList.get(maxList.size() - 1);
        remove(maxNode);
        maxList.remove(maxList.size() - 1);
        if (maxList.size() == 0) {
            treeMap.remove(maxNode.value);
        }
        return maxNode.value;
    }


    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */

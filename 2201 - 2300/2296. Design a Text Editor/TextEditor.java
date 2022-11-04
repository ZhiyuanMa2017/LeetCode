class TextEditor {
    Node head;
    Node cur;

    public TextEditor() {
        head = new Node('a');
        cur = head;
    }

    public void addText(String text) {
        Node next = cur.next;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            Node node = new Node(c);
            cur.next = node;
            node.prev = cur;
            cur = node;
        }
        cur.next = next;
        if (next != null) {
            next.prev = cur;
        }
    }

    public int deleteText(int k) {
        Node next = cur.next;
        int count = 0;
        while (cur != head && count < k) {
            count++;
            cur = cur.prev;
        }
        cur.next = next;
        if (next != null) {
            next.prev = cur;
        }
        return count;
    }

    public String cursorLeft(int k) {
        int count = 0;
        while (cur != head && count < k) {
            count++;
            cur = cur.prev;
        }
        count = 0;
        StringBuilder sb = new StringBuilder();
        Node tmp = cur;
        while (tmp != head && count < 10) {
            count++;
            sb.append(tmp.c);
            tmp = tmp.prev;
        }
        return sb.reverse().toString();
    }

    public String cursorRight(int k) {
        int count = 0;
        while (cur.next != null && count < k) {
            count++;
            cur = cur.next;
        }
        count = 0;
        StringBuilder sb = new StringBuilder();
        Node tmp = cur;
        while (tmp != head && count < 10) {
            count++;
            sb.append(tmp.c);
            tmp = tmp.prev;
        }
        return sb.reverse().toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node tmp = head.next;
        while (tmp != null) {
            sb.append(tmp.c);
            tmp = tmp.next;
        }
        return sb.toString();
    }

    class Node {
        Character c;
        Node next;
        Node prev;

        Node(char c) {
            this.c = c;
        }
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */

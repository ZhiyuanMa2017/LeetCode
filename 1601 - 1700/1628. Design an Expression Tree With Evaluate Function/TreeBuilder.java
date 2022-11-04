import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class NumNode extends Node {
    int num;

    NumNode(int i) {
        num = i;
    }

    public int evaluate() {
        return num;
    }
}

class OpNode extends Node {
    char c;
    Node left;
    Node right;

    OpNode(Character character, Node l, Node r) {
        c = character;
        left = l;
        right = r;
    }

    public int evaluate() {
        int l = this.left.evaluate();
        int r = this.right.evaluate();
        if (c == '+') {
            return l + r;
        } else if (c == '-') {
            return l - r;
        } else if (c == '*') {
            return l * r;
        } else {
            return l / r;
        }
    }
}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Deque<Node> stack = new ArrayDeque<>();
        for (String s : postfix) {
            if (Character.isDigit(s.charAt(0))) {
                stack.push(new NumNode(Integer.parseInt(s)));
            } else {
                Node right = stack.pop();
                Node left = stack.pop();
                stack.push(new OpNode(s.charAt(0), left, right));
            }
        }
        return stack.peek();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */

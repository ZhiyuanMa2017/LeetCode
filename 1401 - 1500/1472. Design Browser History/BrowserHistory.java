import java.util.ArrayDeque;
import java.util.Deque;

class BrowserHistory {
    Deque<String> before;
    Deque<String> after;

    public BrowserHistory(String homepage) {
        before = new ArrayDeque<>();
        after = new ArrayDeque<>();
        before.push(homepage);
    }

    public void visit(String url) {
        before.push(url);
        after.clear();
    }

    public String back(int steps) {
        while (before.size() > 1 && steps > 0) {
            after.push(before.pop());
            steps--;
        }
        return before.peek();
    }

    public String forward(int steps) {
        while (after.size() > 0 && steps > 0) {
            before.push(after.pop());
            steps--;
        }
        return before.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

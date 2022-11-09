import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
    Deque<int[]> stack;
    int index;

    public StockSpanner() {
        stack = new ArrayDeque<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        index = 0;
    }

    public int next(int price) {
        while (!stack.isEmpty() && stack.peek()[1] <= price) {
            stack.pop();
        }
        int res = index - stack.peek()[0];
        stack.push(new int[]{index, price});
        index++;
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

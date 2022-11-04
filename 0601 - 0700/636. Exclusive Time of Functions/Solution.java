import java.util.List;
import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Log> stack = new Stack<>();
        int[] res = new int[n];
        for (String log : logs) {
            Log log1 = new Log(log);
            if (log1.isStart) {
                stack.push(log1);
            } else {
                Log log2 = stack.pop();
                res[log2.id] += log1.time - log2.time + 1;
                if (!stack.isEmpty()) {
                    res[stack.peek().id] -= log1.time - log2.time + 1;
                }
            }
        }
        return res;
    }


    class Log {
        int id;
        int time;
        boolean isStart;

        Log(String s) {
            String[] parts = s.split(":");
            id = Integer.parseInt(parts[0]);
            time = Integer.parseInt(parts[2]);
            isStart = parts[1].equals("start");
        }
    }
}

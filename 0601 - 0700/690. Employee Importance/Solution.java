import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    Map<Integer, Employee> map;

    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return dfs(id);
    }

    private int dfs(int id) {
        Employee cur = map.get(id);
        int res = cur.importance;
        for (int next : cur.subordinates) {
            res += dfs(next);
        }
        return res;
    }
}

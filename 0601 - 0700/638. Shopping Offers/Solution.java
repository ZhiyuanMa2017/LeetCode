import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> sp;
    int res;
    List<Integer> p;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        sp = special;
        p = price;
        res = Integer.MAX_VALUE;
        dfs(needs, 0);
        return res;
    }

    private void dfs(List<Integer> needs, int cost) {
        if (allZero(needs)) {
            res = Math.min(res, cost);
            return;
        }
        int n = needs.size();
        for (List<Integer> spec : sp) {
            List<Integer> cur = new ArrayList<>();
            boolean success = true;
            for (int i = 0; i < n; i++) {
                if (needs.get(i) < spec.get(i)) {
                    success = false;
                    break;
                }
                cur.add(needs.get(i) - spec.get(i));
            }
            if (success) {
                dfs(cur, cost + spec.get(n));
            }
        }
        for (int i = 0; i < p.size(); i++) {
            cost += needs.get(i) * p.get(i);
        }
        res = Math.min(res, cost);

    }

    private boolean allZero(List<Integer> needs) {
        for (Integer need : needs) {
            if (need != 0) {
                return false;
            }
        }
        return true;
    }
}

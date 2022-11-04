import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution2 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> res = new ArrayList<>();
        Set<String> supply = new HashSet<>(Arrays.asList(supplies));
        Map<String, Set<String>> ingredientToRecipes = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        int n = recipes.length;
        for (int i = 0; i < n; i++) {
            int degree = 0;
            for (String s : ingredients.get(i)) {
                if (!supply.contains(s)) {
                    ingredientToRecipes.putIfAbsent(s, new HashSet<>());
                    ingredientToRecipes.get(s).add(recipes[i]);
                    degree++;
                }
            }
            if (degree == 0) {
                res.add(recipes[i]);
            } else {
                inDegree.put(recipes[i], degree);
            }
        }
        Queue<String> q = new LinkedList<>(res);
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (ingredientToRecipes.containsKey(cur)) {
                for (String s : ingredientToRecipes.get(cur)) {
                    if (inDegree.get(s) == 1) {
                        q.offer(s);
                        res.add(s);
                        inDegree.remove(s);
                    } else {
                        inDegree.put(s, inDegree.get(s) - 1);
                    }
                }
            }
        }
        return res;
    }
}

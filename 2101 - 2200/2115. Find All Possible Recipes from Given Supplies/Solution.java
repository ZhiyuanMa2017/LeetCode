import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        List<String> res = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String recipe = recipes[i];
            for (String ingredient : ingredients.get(i)) {
                if (!graph.containsKey(ingredient)) {
                    graph.put(ingredient, new ArrayList<>());
                }
                graph.get(ingredient).add(recipe);
                inDegree.put(recipe, inDegree.getOrDefault(recipe, 0) + 1);
            }
        }
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(supplies));
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (!graph.containsKey(cur)) {
                continue;
            }
            for (String next : graph.get(cur)) {
                if (inDegree.get(next) == 1) {
                    queue.offer(next);
                    res.add(next);
                }
                inDegree.put(next, inDegree.get(next) - 1);
            }
        }
        return res;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> res = new ArrayList<>();
        int count = 0;
        int n = recipes.length;
        Set<String> supply = new HashSet<>(Arrays.asList(supplies));
        boolean[] find = new boolean[n];
        while (true) {
            for (int i = 0; i < ingredients.size(); i++) {
                if (!find[i] && supply.containsAll(ingredients.get(i))) {
                    res.add(recipes[i]);
                    supply.add(recipes[i]);
                    find[i] = true;
                }
            }
            if (count == res.size()) {
                break;
            }
            count = res.size();
        }
        return res;
    }
}

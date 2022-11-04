import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        Arrays.sort(products);
        List<String> productsList = Arrays.asList(products);
        for (int i = 0; i < products.length; i++) {
            treeMap.put(products[i], i);
        }
        String key = "";
        for (char c : searchWord.toCharArray()) {
            key += c;
            Object key1;
            String floor = treeMap.floorKey(key + "{");
            String ceiling = treeMap.ceilingKey(key);
            if (floor == null || ceiling == null) {
                break;
            }
            res.add(productsList
                    .subList(
                            treeMap.get(ceiling),
                            Math.min(treeMap.get(ceiling) + 3, treeMap.get(floor) + 1)));
        }
        while (res.size() < searchWord.length()) {
            res.add(new ArrayList<>());
        }
        return res;
    }
}

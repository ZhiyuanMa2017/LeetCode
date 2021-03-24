import java.util.TreeMap;

class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < A.length; i++) {
            treeMap.put(A[i], treeMap.getOrDefault(A[i], 0) + 1);
        }
        int[] res = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            Integer higher = treeMap.higherKey(B[i]);
            if (higher == null) {
                higher = treeMap.firstKey();
            }
            res[i] = higher;
            treeMap.put(higher, treeMap.get(higher) - 1);
            if (treeMap.get(higher) == 0) {
                treeMap.remove(higher);
            }
        }
        return res;
    }
}

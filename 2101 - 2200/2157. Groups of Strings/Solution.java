import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] groupStrings(String[] words) {
        int n = words.length;
        UF uf = new UF(n);
        Map<Integer, Integer> maskToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = words[i];
            int curMask = 0;
            for (int j = 0; j < s.length(); j++) {
                curMask |= (1 << (s.charAt(j) - 'a'));
            }
            if (maskToIndex.containsKey(curMask)) {
                uf.union(i, maskToIndex.get(curMask));
            } else {
                for (int j = 0; j < 26; j++) {
                    int addOrDelete = curMask ^ (1 << j);
                    if (maskToIndex.containsKey(addOrDelete)) {
                        uf.union(i, maskToIndex.get(addOrDelete));
                    }
                }
                for (int j = 0; j < 26; j++) {
                    int checkOne = 1 << j;
                    if ((curMask & checkOne) == 0) {
                        continue;
                    }
                    for (int k = 0; k < 26; k++) {
                        int checkZero = 1 << k;
                        if ((curMask & checkZero) > 0) {
                            continue;
                        }
                        int replace = curMask ^ checkOne ^ checkZero;
                        if (maskToIndex.containsKey(replace)) {
                            uf.union(i, maskToIndex.get(replace));
                        }
                    }
                }
            }
            if (!maskToIndex.containsKey(curMask)) {
                maskToIndex.put(curMask, i);
            }
        }
        int group = 0;
        int max = 0;
        for (int i = 0; i < uf.size.length; i++) {
            int p = uf.find(i);
            if (p == i) {
                group++;
                max = Math.max(max, uf.size[i]);
            }
        }
        return new int[]{group, max};
    }

    class UF {
        int[] parent;
        int[] size;


        UF(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public void union(int i, int j) {
            int p = find(i);
            int q = find(j);
            if (p == q) {
                return;
            }
            if (size[p] >= size[q]) {
                parent[q] = p;
                size[p] += size[q];
            } else {
                parent[p] = q;
                size[q] += size[p];
            }
        }
    }
}

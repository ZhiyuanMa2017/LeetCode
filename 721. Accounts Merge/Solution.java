import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UF uf = new UF(n);
        Map<String, Integer> mailToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!mailToIndex.containsKey(email)) {
                    mailToIndex.put(email, i);
                } else {
                    uf.union(i, mailToIndex.get(email));
                }
            }
        }
        Map<Integer, Set<String>> indexToMails = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = uf.find(i);
            indexToMails.putIfAbsent(parent, new HashSet<>());
            Set<String> set = indexToMails.get(parent);
            for (int j = 1; j < accounts.get(i).size(); j++) {
                set.add(accounts.get(i).get(j));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Integer index : indexToMails.keySet()) {
            List<String> nameAndEmails = new ArrayList<>(indexToMails.get(index));
            Collections.sort(nameAndEmails);
            nameAndEmails.add(0, accounts.get(index).get(0));
            res.add(nameAndEmails);
        }
        return res;
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

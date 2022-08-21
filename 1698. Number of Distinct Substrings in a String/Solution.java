class Solution {
    public int countDistinct(String s) {
        Tire root = new Tire();
        int res = 0;
        Tire cur;
        for (int i = 0; i < s.length(); i++) {
            cur = root;
            for (int j = i; j < s.length(); j++) {
                if (cur.children[s.charAt(j) - 'a'] == null) {
                    res++;
                    cur.children[s.charAt(j) - 'a'] = new Tire();
                }
                cur = cur.children[s.charAt(j) - 'a'];
            }
        }
        return res;
    }

    class Tire {
        Tire[] children;

        Tire() {
            children = new Tire[26];
        }
    }
}

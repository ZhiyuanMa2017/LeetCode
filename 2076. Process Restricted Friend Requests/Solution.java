import java.util.Arrays;

class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        UF uf = new UF(n);
        boolean[] res = new boolean[requests.length];
        Arrays.fill(res, true);
        for (int i = 0; i < requests.length; i++) {
            int[] request = requests[i];
            int a = request[0];
            int b = request[1];
            int aP = uf.find(a);
            int bP = uf.find(b);
            for (int[] restriction : restrictions) {
                int r1 = uf.find(restriction[0]);
                int r2 = uf.find(restriction[1]);
                if ((aP == r1 && bP == r2) || (aP == r2 && bP == r1)) {
                    res[i] = false;
                    break;
                }
            }
            if (res[i]) {
                uf.union(a, b);
            }
        }
        return res;
    }

    class UF {
        int[] p;
        int[] size;

        UF(int n) {
            p = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
                size[i] = 1;
            }
        }

        int find(int i) {
            while (i != p[i]) {
                p[i] = p[p[i]];
                i = p[i];
            }
            return i;
        }

        void union(int i, int j) {
            int parentI = find(i);
            int parentJ = find(j);
            if (parentI == parentJ) {
                return;
            } else if (parentI > parentJ) {
                p[parentJ] = parentI;
                size[parentI] += size[parentJ];
            } else {
                p[parentI] = parentJ;
                size[parentJ] += size[parentI];
            }
        }
    }
}

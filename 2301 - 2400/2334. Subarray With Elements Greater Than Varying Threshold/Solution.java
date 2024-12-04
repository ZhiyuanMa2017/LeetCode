import java.util.PriorityQueue;

class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        UF uf = new UF(n);
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int num = cur[0];
            int index = cur[1];
            if (index > 0 && nums[index - 1] >= num) {
                uf.union(index - 1, index);
            }
            if (index < n - 1 && nums[index + 1] >= num) {
                uf.union(index, index + 1);
            }
            if (num > threshold / uf.size[uf.find(index)]) {
                return uf.size[uf.find(index)];
            }
        }
        return -1;
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

        int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        void union(int i, int j) {
            int p = find(i);
            int q = find(j);
            if (p == q) {
                return;
            } else if (size[p] >= size[q]) {
                parent[q] = p;
                size[p] += size[q];
            } else {
                parent[p] = q;
                size[q] += size[p];
            }
        }
    }
}

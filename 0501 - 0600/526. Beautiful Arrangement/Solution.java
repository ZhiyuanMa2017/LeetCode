class Solution {
    int res;

    public int countArrangement(int n) {
        res = 0;
        boolean[] visited = new boolean[n + 1];
        backtrack(n, visited, 0);
        return res;
    }

    private void backtrack(int n, boolean[] visited, int size) {
        if (size == n) {
            res++;
            return;
        }
        for (int i = n; i >= 0; i--) {
            if (visited[i]) {
                continue;
            }
            int index = size + 1;
            if (i % index != 0 && index % i != 0) {
                continue;
            }
            visited[i] = true;
            backtrack(n, visited, size + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countArrangement(3));
    }
}

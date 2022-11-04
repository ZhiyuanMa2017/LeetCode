class Solution {
    public int heightChecker(int[] heights) {
        int[] bucket = new int[101];
        for (int height : heights) {
            bucket[height]++;
        }
        int index = 1;
        int res = 0;
        for (int height : heights) {
            while (bucket[index] == 0) {
                index++;
            }
            if (height != index) {
                res++;
            }
            bucket[index]--;
        }
        return res;
    }
}

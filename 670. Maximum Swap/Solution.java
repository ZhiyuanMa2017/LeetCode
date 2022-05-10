class Solution {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] lastGreater = new int[chars.length];
        int curMaxIndex = chars.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] > chars[curMaxIndex]) {
                curMaxIndex = i;
            }
            lastGreater[i] = curMaxIndex;
        }

        for (int i = 0; i < chars.length; i++) {
            if (lastGreater[i] != i && chars[lastGreater[i]] != chars[i]) {
                char tmp = chars[i];
                chars[i] = chars[lastGreater[i]];
                chars[lastGreater[i]] = tmp;
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}

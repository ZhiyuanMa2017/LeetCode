class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();
        int lower = 0;
        int upper = 0;
        int digit = 0;
        for (int i = 0; i < n; i++) {
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                upper = 1;
            } else if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                lower = 1;
            } else if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                digit = 1;
            }
        }
        int conditionTwo = lower + upper + digit;
        if (password.length() < 6) {
            return Math.max(6 - n, 3 - conditionTwo);
        } else if (password.length() <= 20) {
            int threeCount = 0;
            int i = 0;
            while (i < n) {
                int j = i;
                while (i < n && password.charAt(i) == password.charAt(j)) {
                    i++;
                }
                int curCount = i - j;
                threeCount += curCount / 3;
            }
            return Math.max(threeCount, 3 - conditionTwo);
        } else {
            int threeCount = 0;
            int[] modCount = new int[3];
            int i = 0;
            while (i < n) {
                int j = i;
                while (i < n && password.charAt(i) == password.charAt(j)) {
                    i++;
                }
                int curCount = i - j;
                if (curCount >= 3) {
                    threeCount += curCount / 3;
                    modCount[curCount % 3]++;
                }
            }
            int toDelete = n - 20;
            int cur = toDelete;
            for (int mod = 0; mod < 3; mod++) {
                if (mod == 2) {
                    modCount[mod] = threeCount;
                }
                if (modCount[mod] != 0 && cur > 0) {
                    int usedForThree = Math.min(modCount[mod] * (mod + 1), cur);
                    cur -= usedForThree;
                    threeCount -= usedForThree / (mod + 1);
                }
            }
            return Math.max(threeCount, 3 - conditionTwo) + toDelete;
        }
    }
}

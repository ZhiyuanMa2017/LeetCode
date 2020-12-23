import java.util.Arrays;

class Solution {
    public int nextGreaterElement(int n) {
        char[] num = String.valueOf(n).toCharArray();
        int i;
        for (i = num.length - 1; i > 0; i--) {
            if (num[i - 1] < num[i]) {
                break;
            }
        }
        if (i == 0) {
            return -1;
        }
        char numbertochange = num[i - 1];
        int smallestindex = i;
        for (int j = num.length - 1; j > i - 1; j--) {
            if (num[j] <= num[smallestindex] && num[j] > numbertochange) {
                smallestindex = j;
            }
        }
        num[i - 1] = num[smallestindex];
        num[smallestindex] = numbertochange;
        Arrays.sort(num, i, num.length);
        long res = Long.parseLong(String.valueOf(num));
        if (res > Integer.MAX_VALUE) {
            return -1;
        } else {
            return (int) res;
        }

    }
}

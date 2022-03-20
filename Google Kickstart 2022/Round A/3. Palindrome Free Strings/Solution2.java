import java.util.*;

public class Solution2 {
    // https://codingcompetitions.withgoogle.com/kickstart/submissions/00000000008cb33e/000000000054f3c8
    static Scanner sc = new Scanner(System.in);

    static boolean[][] memo;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int t = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= t; ++i) {
            solve(i);
        }
    }

    private static void solve(int t) {
        sc.nextLine();
        String s = sc.nextLine();

        int[] arr = new int[s.length()];

        memo = new boolean[arr.length][32];
        String result = possible(arr, s, 0) ? "POSSIBLE" : "IMPOSSIBLE";

        print(t, result);
    }

    private static int getKey(int[] arr, int idx) {
        int result = 0;

        for (int j = idx - 1; j >= 0 && j >= idx - 5; --j) {
            result = result * 2 + arr[j];
        }

        return result;
    }

    private static boolean possible(int[] arr, String s, int idx) {
        if (idx == arr.length) {
            return true;
        }

        int key = getKey(arr, idx);

        if (memo[idx][key]) {
            return false;
        }

        memo[idx][key] = true;

        char c = s.charAt(idx);
        int[] vals = new int[c == '?' ? 2 : 1];

        if (c == '?') {
            vals[0] = 0;
            vals[1] = 1;
        } else {
            vals[0] = c - '0';
        }

        for (int val : vals) {
            arr[idx] = val;

            if (isPalindrome(arr, idx - 5, idx) || isPalindrome(arr, idx - 4, idx)) {
                continue;
            }

            if (possible(arr, s, idx + 1)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isPalindrome(int[] arr, int low, int high) {
        if (low < 0) {
            return false;
        }

        while (low < high) {
            if (arr[low++] != arr[high--]) {
                return false;
            }
        }

        return true;
    }

    private static void print(int t, String result) {
        System.out.println("Case #" + t + ": " + result);
    }

}

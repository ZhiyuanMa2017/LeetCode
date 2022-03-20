import java.util.Scanner;

class Solution {
    // https://codingcompetitions.withgoogle.com/kickstart/round/00000000008cb33e/00000000009e762e

    static Scanner scanner = new Scanner(System.in);

    public static void solve(int t) {
        String I = scanner.nextLine();
        String S = scanner.nextLine();

        int[] nums = new int[S.length()];

        String res = dfs(nums, S, 0) ? "POSSIBLE" : "IMPOSSIBLE";

        print(t, res);
    }

    private static boolean dfs(int[] nums, String S, int index) {
        if (index == nums.length) {
            return true;
        }
        if (S.charAt(index) != '?') {
            nums[index] = S.charAt(index) - '0';
            if (isPalindrome(nums, index - 5, index) || isPalindrome(nums, index - 4, index)) {
                return false;
            } else {
                return dfs(nums, S, index + 1);
            }
        } else {
            for (int i = 0; i <= 1; i++) {
                nums[index] = i;
                if (isPalindrome(nums, index - 5, index) || isPalindrome(nums, index - 4, index)) {
                    continue;
                }
                if (dfs(nums, S, index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean isPalindrome(int[] nums, int left, int right) {
        if (left < 0) {
            return false;
        }
        while (left < right) {
            if (nums[left] != nums[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static void print(int t, String res) {
        System.out.println("Case #" + t + ": " + res);
    }

    public static void main(String[] args) {
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= t; i++) {
            solve(i);
        }
    }
}

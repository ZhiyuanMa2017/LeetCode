import java.util.Scanner;

class Solution {

    static Scanner scanner = new Scanner(System.in);

    public static void solve(int t) {
        String P = scanner.nextLine();
        long num = Long.parseLong(P);
        long count = 0;
        long start = 1;
        while (start * start <= num) {
            if (num % start == 0) {
                if (isPalindrome(start)) {
                    count++;
                }
                if (num / start != start) {
                    if (isPalindrome(num / start)) {
                        count++;
                    }
                }
            }
            start++;
        }

        print(t, String.valueOf(count));
    }

    private static boolean isPalindrome(long i) {
        String s = String.valueOf(i);
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
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

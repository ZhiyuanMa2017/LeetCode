import java.util.*;

public class Solution2 {
    // https://codingcompetitions.withgoogle.com/kickstart/submissions/00000000008cb33e/000000000054f3c8
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int t = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= t; ++i) {
            solve(i);
        }
    }

    private static void solve(int t) {
        String s = sc.nextLine();

        String n = sc.nextLine();

        int sIdx = 0;

        for (char c : n.toCharArray()) {
            if (sIdx < s.length() && c == s.charAt(sIdx)) {
                ++sIdx;
            }
        }

        String res = sIdx == s.length() ? ("" + (n.length() - s.length())) : "IMPOSSIBLE";
        print(t, res);
    }

    private static void print(int t, String result) {
        System.out.println("Case #" + t + ": " + result);
    }

}

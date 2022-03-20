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

        int sum = 0;

        for (char c : s.toCharArray()) {
            sum += c - '0';
        }

        sum %= 9;
        int mod = 9 - sum;
        mod %= 9;

        StringBuilder sb = new StringBuilder();

        boolean added = false;

        int val;

        for (int i = 0; i < s.length(); ++i) {
            val = s.charAt(i) - '0';

            if (!added && mod < val && (mod != 0 || i != 0)) {
                added = true;
                sb.append(mod);
            }

            sb.append(val);
        }

        if (!added) {
            sb.append(mod);
        }

        print(t, sb.toString());
    }

    private static void print(int t, String result) {
        System.out.println("Case #" + t + ": " + result);
    }

}


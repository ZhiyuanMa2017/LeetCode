import java.util.Scanner;

class Solution {
    // https://codingcompetitions.withgoogle.com/kickstart/round/00000000008cb33e/00000000009e7021

    static Scanner scanner = new Scanner(System.in);

    public static void solve(int t) {
        String I = scanner.nextLine();
        String P = scanner.nextLine();

        int i = 0;
        int j = 0;
        while (i < I.length() && j < P.length()) {
            if (I.charAt(i) == P.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        String res = i == I.length() ? String.valueOf(P.length() - I.length()) : "IMPOSSIBLE";
        print(t, res);
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

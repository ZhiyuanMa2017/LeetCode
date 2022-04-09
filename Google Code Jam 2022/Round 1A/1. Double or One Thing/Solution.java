import java.util.Scanner;

class Solution {

    static Scanner scanner = new Scanner(System.in);

    public static void solve(int t) {
        String I = scanner.nextLine();
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < I.length()) {
            int j = i + 1;
            while (j < I.length() && I.charAt(i) == I.charAt(j)) {
                j++;
            }
            if (j >= I.length()) {
                res.append(I, i, j);
            } else {
                String sub = I.substring(i, j);
                if (I.charAt(i) < I.charAt(j)) {
                    res.append(sub).append(sub);
                } else {
                    res.append(sub);
                }
            }
            i = j;
        }
        print(t, res.toString());
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

import java.util.Scanner;

class Solution {
    public static int solve(Scanner scanner) {
        String I = scanner.nextLine();
        String P = scanner.nextLine();
        if (I.length() == P.length() && !I.equals(P)) {
            return -1;
        }
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < I.length() && j < P.length()) {
            if (I.charAt(i) == P.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
                res++;
            }
        }
        if (i == I.length()) {
            return res + P.length() - j;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int caseNum = Integer.parseInt(input.nextLine());
        for (int ks = 1; ks <= caseNum; ks++) {
            int res = solve(input);
            if (res == -1) {
                System.out.printf("Case #%d: %s%n", ks, "IMPOSSIBLE");
            } else {
                System.out.printf("Case #%d: %d%n", ks, res);
            }
        }
    }
}

import java.util.Scanner;

class Solution {

    static Scanner scanner = new Scanner(System.in);

    public static void solve(int t) {
        String one = scanner.nextLine();
        String two = scanner.nextLine();
        String three = scanner.nextLine();
        String[] ones = one.split(" ");
        String[] twos = two.split(" ");
        String[] threes = three.split(" ");

        int[] A = new int[4];
        for (int i = 0; i < ones.length; i++) {
            A[i] = Integer.parseInt(ones[i]);
        }
        int[] B = new int[4];
        for (int i = 0; i < ones.length; i++) {
            B[i] = Integer.parseInt(twos[i]);
        }
        int[] C = new int[4];
        for (int i = 0; i < ones.length; i++) {
            C[i] = Integer.parseInt(threes[i]);
        }

        int minCyan = Math.min(A[0], Math.min(B[0], C[0]));
        int minMagenta = Math.min(A[1], Math.min(B[1], C[1]));
        int minYellow = Math.min(A[2], Math.min(B[2], C[2]));
        int minBlack = Math.min(A[3], Math.min(B[3], C[3]));

        String res;
        if (minCyan + minMagenta + minYellow + minBlack < 1000000) {
            res = "IMPOSSIBLE";
        } else {
            int[] nums = new int[4];
            int[] colors = new int[]{minCyan, minMagenta, minYellow, minBlack};
            int total = 1000000;
            for (int i = 0; i < 4; i++) {
                nums[i] = Math.min(total, colors[i]);
                total -= colors[i];
                if (total <= 0) {
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.setLength(sb.length() - 1);
            res = sb.toString();
        }

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

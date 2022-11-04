import java.util.Arrays;

class Further {
    public int[] getModifiedArray(int[] arr, int[][] updates) {
        int n = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] -= arr[i - 1];
        }
        for (int[] u : updates) {
            arr[u[0]] += u[2];
            if (u[1] + 1 < n) {
                arr[u[1] + 1] += -u[2];
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            arr[i] = sum;
        }
        return arr;
    }

    public static void main(String[] args) {
        Further f = new Further();
        System.out.println(
                Arrays.toString(
                        f.getModifiedArray(new int[]{3, 2, 3, 7, 5},
                                new int[][]{{0, 2, 2}})));
    }
}

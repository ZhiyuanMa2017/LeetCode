class Solution {
    public String originalDigits(String s) {
        /*
        0 zero z    e r o
        2 two w     t o
        4 four u    f o r
        6 six x     s i
        8 eight g   e i h t
        1 one o n e
        3 three t h r e e
        5 five f i v e
        7 seven s e v e n
        9 nine n i n e

        z: 0
        w: 2
        u: 4
        x: 6
        g: 8
        // e: 0 + 8 + 1 + 3 + 3 + 5 + 7 + 7 + 9
        f: 4 + 5     5 = f - u
        h: 8 + 3     3 = h - g
        i: 6 + 8 + 5 + 9     9 = i - x - g - 5
        // n: 1 + 7 + 9 + 9
        o: 0 + 2 + 4 + 1   1 = o - w - u - z
        s: 6 + 7     7 = s - x
        // t: 2 + 8 + 3

        0 2 4 6 8 3 5 7  1 9
         */
        int[] freq = new int[10];
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'z':
                    freq[0]++;
                    break;
                case 'w':
                    freq[2]++;
                    break;
                case 'u':
                    freq[4]++;
                    break;
                case 'x':
                    freq[6]++;
                    break;
                case 'g':
                    freq[8]++;
                    break;
                case 'f':
                    freq[5]++;
                    break;
                case 'h':
                    freq[3]++;
                    break;
                case 'i':
                    freq[9]++;
                    break;
                case 'o':
                    freq[1]++;
                    break;
                case 's':
                    freq[7]++;
                    break;
                default:
            }
        }
        freq[5] = freq[5] - freq[4];
        freq[3] = freq[3] - freq[8];
        freq[7] = freq[7] - freq[6];
        freq[1] = freq[1] - freq[0] - freq[2] - freq[4];
        freq[9] = freq[9] - freq[6] - freq[8] - freq[5];

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < freq[i]; j++) {
                stringBuilder.append(i);
            }
        }
        return stringBuilder.toString();
    }
}

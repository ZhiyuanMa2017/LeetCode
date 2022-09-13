class Solution {
    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            int cur = data[i];
            if (cur < 0b10000000) {
                i++;
            } else if ((cur & 0b11100000) == 0b11000000) {
                if (i + 1 >= data.length) {
                    return false;
                }
                if ((data[i + 1] & 0b11000000) != 0b10000000) {
                    return false;
                }
                i += 2;
            } else if ((cur & 0b11110000) == 0b11100000) {
                if (i + 1 >= data.length || i + 2 >= data.length) {
                    return false;
                }
                if ((data[i + 1] & 0b11000000) != 0b10000000 || (data[i + 2] & 0b11000000) != 0b10000000) {
                    return false;
                }
                i += 3;
            } else if ((cur & 0b11111000) == 0b11110000) {
                if (i + 1 >= data.length || i + 2 >= data.length || i + 3 >= data.length) {
                    return false;
                }
                if ((data[i + 1] & 0b11000000) != 0b10000000 || (data[i + 2] & 0b11000000) != 0b10000000 || (data[i + 3] & 0b11000000) != 0b10000000) {
                    return false;
                }
                i += 4;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.validUtf8(new int[]{197, 130, 1});
    }
}

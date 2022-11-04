class Solution {
    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            int cur = data[i] & 0xff;
            if (cur < 0x80) {
                i++;
            } else if ((cur & 0xe0) == 0xc0) {
                if (i + 1 >= data.length) {
                    return false;
                }
                if ((data[i + 1] & 0xc0) != 0x80) {
                    return false;
                }
                i += 2;
            } else if ((cur & 0xf0) == 0xe0) {
                if (i + 1 >= data.length || i + 2 >= data.length) {
                    return false;
                }
                if ((data[i + 1] & 0xc0) != 0x80 || (data[i + 2] & 0xc0) != 0x80) {
                    return false;
                }
                i += 3;
            } else if ((cur & 0xf8) == 0xf0) {
                if (i + 1 >= data.length || i + 2 >= data.length || i + 3 >= data.length) {
                    return false;
                }
                if ((data[i + 1] & 0xc0) != 0x80 || (data[i + 2] & 0xc0) != 0x80 || (data[i + 3] & 0xc0) != 0x80) {
                    return false;
                }
                i += 4;
            } else {
                return false;
            }
        }
        return true;
    }
}

class CombinationIterator {
    int len;
    int mask;
    String s;

    public CombinationIterator(String characters, int combinationLength) {
        s = characters;
        mask = (1 << characters.length()) - 1;
        len = combinationLength;
    }

    private int countOne() {
        int curMask = mask;
        int count = 0;
        while (curMask > 0) {
            count += curMask & 1;
            curMask >>= 1;
        }
        return count;
    }

    private String getNext() {
        int curMask = mask;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (curMask > 0) {
            if ((curMask & 1) == 1) {
                sb.append(s.charAt(s.length() - index - 1));
            }
            index++;
            curMask >>= 1;
        }
        return sb.reverse().toString();
    }

    public String next() {
        while (mask > 0 && countOne() != len) {
            mask--;
        }
        String res = getNext();
        mask--;
        return res;
    }

    public boolean hasNext() {
        while (mask > 0 && countOne() != len) {
            mask--;
        }
        return mask > 0;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

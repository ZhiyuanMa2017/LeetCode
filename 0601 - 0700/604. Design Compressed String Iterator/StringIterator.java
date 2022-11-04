class StringIterator {
    int index;
    char c;
    int num;
    String s;

    public StringIterator(String compressedString) {
        s = compressedString;
        index = 0;
        num = 0;
    }

    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        if (num == 0) {
            c = s.charAt(index);
            index++;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                num = num * 10 + (s.charAt(index) - '0');
                index++;
            }
        }
        num--;
        return c;
    }

    public boolean hasNext() {
        return index < s.length() || num > 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

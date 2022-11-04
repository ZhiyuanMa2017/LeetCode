class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int count;
        int i = 0;
        while (i < chars.length) {
            char c = chars[i];
            count = 0;
            while (i < chars.length && chars[i] == c) {
                i++;
                count++;
            }
            chars[index] = c;
            index++;
            if (count > 1) {
                char[] num = Integer.toString(count).toCharArray();
                for (char value : num) {
                    chars[index] = value;
                    index++;
                }
            }

        }
        return index;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }
}

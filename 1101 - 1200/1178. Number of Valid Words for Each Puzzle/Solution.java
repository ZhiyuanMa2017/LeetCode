import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int hash = getHash(word);
            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (String puzzle : puzzles) {
            int count = 0;
            int n = puzzle.length();
            char[] chars = puzzle.toCharArray();
            int first = chars[0] - 'a';
            // 枚举「保留首个字母」的所有子集
            // 即我们需要先固定 puzzle 的首位字母，然后枚举剩余的 6 位是否保留
            // 由于是二进制，每一位共有 0 和 1 两种选择，因此共有 2^6 种可能性，也就是 2^6 = 1 << (7 - 1) = 64 种
            // i 代表了所有「保留首个字母」的子集的「后六位」的二进制表示
            // i 在这里是十进制数
            // 这里的i,j是对应的puzzle里的位数上字母是否出现在子可能里
            // 举个🌰吧，假如我们有 puzzle 是 gabc（假定现在的 puzzle 长度只有 4） ，那么可能有哪些？
            // 一，必然包含首字母 g；
            // 二，可能包括 g、ga、gb、gc、gab、gac、gbc、gabc。
            // 使用 1 和 0 代表 puzzle 每一位选择与否的话，
            // 其实就是对应了 1000、1100、1010、1001、1110、1101、1011、1111。
            for (int i = 0; i < 1 << n - 1; i++) {
                // 枚举所有可能，再看哪些可能出现在了words里
                // 第一个字母必须出现
                int thisHash = 1 << first;
                for (int j = 1; j < n; j++) {
                    // 第j位是1,那把第j位的对应二进制编进hash里
                    if (((i >> (j - 1)) & 1) != 0) {
                        thisHash += 1 << (chars[j] - 'a');
                    }
                }
                // 编完这个可能的hash，看这个可能是否出现了
                if (map.containsKey(thisHash)) {
                    count += map.get(thisHash);
                }
            }
            res.add(count);
        }
        return res;
    }

    // 将 str 所包含的字母用二进制标识
    // 如果 str = abz 则对应的二进制为 100...011 (共 26 位，从右往左是 a - z)
    private int getHash(String s) {
        int hash = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            // 每一位字符所对应二进制数字中哪一位
            int digitToRight = c - 'a';
            // 如果当前位置为 0，代表还没记录过，则进行记录 (不重复记录)
            if ((hash >> digitToRight & 1) == 0) {
                hash += 1 << digitToRight;
            }
        }
        return hash;
    }
}

import java.util.Arrays;

public class DataStructures {

    public static void main(String[] args) {
        DataStructures dataStructures = new DataStructures();
        dataStructures.number();
    }

    public void number() {
        String intS = new String("1234");
        int intNum = Integer.parseInt(intS);
        // O(n)
        String binaryS = new String("101");
        int intNum2 = Integer.parseInt(binaryS, 2);
        // 5

        Integer integerNum = Integer.valueOf(binaryS, 2);
        // Object Integer 5

        String doubleS = new String("123.456");
        double doubleNum = Double.parseDouble(doubleS);

        float floatNum = Float.parseFloat(doubleS);

        String longS = new String("10000000000000");
        long longNum = Long.parseLong(longS);

        String binaryS2 = Integer.toBinaryString(16);
        // 10000

        int maxVal = Integer.MAX_VALUE;
        // 2147483647
        // 2^31 = 2147483648
        int minVal = Integer.MIN_VALUE;
        // -2147483648
        long temp = (long) Math.pow(2, 31);
        System.out.println(String.valueOf(temp));

    }

    public void string() {
        String s = new String("apple banana orange");
        String sub = s.substring(1, 3);
        // pp, include 1, exclude 3
        // O(n)
        int len = s.length();
        char c = s.charAt(3);
        // l
        String[] words = s.split(" ");
        // [apple, banana, orange]
        // O(n)?
        int index = s.indexOf('a', 3);
        // 7
        // O(n*m)
        String upper = s.toUpperCase();
        // APPLE BANANA ORANGE
        boolean startWith = s.startsWith("app");
        // true
        // O(m)
        boolean startWithOffset = s.startsWith("bana", 6);
        // true

        String spaceS = new String("   apple banana   ");
        String trimSpaceS = spaceS.trim();

        String regexS = new String("abc+def.ghi\\jkl mn   opq rest    uvw xyz");
        System.out.println(regexS);
        System.out.println(Arrays.toString(regexS.split(" ")));
        // [abc+def.ghi\jkl, mn, , , opq, rest, , , , uvw, xyz]

        System.out.println(Arrays.toString(regexS.split("\\.")));
        // [abc+def, ghi\jkl mn   opq rest    uvw xyz]

        System.out.println(Arrays.toString(regexS.split("\\s")));
        // [abc+def.ghi\jkl, mn, , , opq, rest, , , , uvw, xyz]
        // matches single whitespace character

        System.out.println(Arrays.toString(regexS.split("\\s+")));
        // [abc+def.ghi\jkl, mn, opq, rest, uvw, xyz]
        // matches sequence of one or more whitespace characters

        System.out.println(Arrays.toString(regexS.split("\\\\")));
        // [abc+def.ghi, jkl mn   opq rest    uvw xyz]
        // match \


        String regexS2 = new String("ds\\sdsd\\\\dsd\\ds\\padd");
        System.out.println(regexS2);
        // ds\sdsd\\dsd\ds\padd
        System.out.println(Arrays.toString(regexS2.split("\\\\+")));
        // [ds, sdsd, dsd, ds, padd]
        // match sequence of one or more \
        System.out.println(Arrays.toString(regexS2.split("\\\\\\\\")));
        // [ds\sdsd, dsd\ds\padd]
        // match \\

        int i = 16;
        String intS = String.valueOf(i);
        // it calls Integer.toString(i);
        String intS2 = Integer.toString(i);
        // 16
        String nullS = Integer.toString(i, 2);
        // 10000

        char[] chars = new char[]{'a', 'b', 'c'};
        String cS = new String(chars);
        String cS2 = String.valueOf(chars);
        String cS3 = String.copyValueOf(chars);
        // these two methods are equivalent

        String cS4 = Character.toString('a');
        // it calls String.valueOf(c);

        char[] sToChars = "abcdefg".toCharArray();
    }

    public void array() {
        int[] nums = new int[]{1, 2, 3};
        int len = nums.length;
        int num = nums[1];
        // O(1)

        int[] nums2 = new int[10];
        Arrays.fill(nums2, 8);
        System.out.println(nums2.toString());
        // [I@1e643faf
        // Returns a string representation of the object
        System.out.println(Arrays.toString(nums2));
        // [8, 8, 8, 8, 8, 8, 8, 8, 8, 8]

        int[][] nums3 = new int[][]{{1, 2}, {3, 4}};
        System.out.println(Arrays.toString(nums3));
        // [[I@1e643faf, [I@6e8dacdf]
        System.out.println(Arrays.deepToString(nums3));
        // [[1, 2], [3, 4]]

        String[] words = new String[]{"abc", "def"};
        System.out.println(words.toString());
        // [Ljava.lang.String;@b684286
        System.out.println(Arrays.toString(words));
    }
}

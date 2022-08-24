import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aSum = 0;
        Set<Integer> set = new HashSet<>();
        for (int aliceSize : aliceSizes) {
            set.add(aliceSize);
            aSum += aliceSize;
        }
        int bSum = 0;
        for (int bobSize : bobSizes) {
            bSum += bobSize;
        }
        int diff = aSum - bSum;
        diff /= 2;
        for (int bobSize : bobSizes) {
            if (set.contains(bobSize + diff)) {
                return new int[]{bobSize + diff, bobSize};
            }
        }
        return new int[]{};
    }
}

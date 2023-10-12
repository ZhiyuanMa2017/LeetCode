/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int peak = l;
        int left = findl(target, mountainArr, 0, peak);
        if (left != -1) {
            return left;
        }
        return findr(target, mountainArr, peak, n - 1);
    }

    private int findl(int target, MountainArray mountainArray, int l, int r) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            int v = mountainArray.get(mid);
            if (v == target) {
                return mid;
            } else if (v < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return target == mountainArray.get(l) ? l : -1;
    }

    private int findr(int target, MountainArray mountainArray, int l, int r) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            int v = mountainArray.get(mid);
            if (v == target) {
                return mid;
            } else if (v > target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return target == mountainArray.get(l) ? l : -1;
    }
}

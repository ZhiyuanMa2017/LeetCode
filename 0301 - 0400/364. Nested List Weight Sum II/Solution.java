/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 * <p>
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 * <p>
 * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 * public void add(NestedInteger ni);
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
class Solution {
    int maxDepth;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        maxDepth = getDepth(nestedList);
        int res = dfs(nestedList, 1);
        return res;
    }

    private int dfs(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        int cur;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                cur = (maxDepth - depth + 1) * ni.getInteger();
            } else {
                cur = dfs(ni.getList(), depth + 1);
            }
            res += cur;
        }
        return res;

    }

    private int getDepth(List<NestedInteger> nestedList) {
        int max = 0;
        for (NestedInteger ni : nestedList) {
            int cur = 0;
            if (ni.isInteger()) {
                cur = 0;
            } else {
                cur = getDepth(ni.getList());
            }
            max = Math.max(max, cur);
        }
        return max + 1;
    }
}

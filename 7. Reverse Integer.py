class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        reverse = str(x)[::-1]
        if x<0:
            result = int(reverse[:-1])*-1
        else:
            result = int(reverse)
        if result > -2**31-1 and result <2**31:
            return result
        else:
            return 0

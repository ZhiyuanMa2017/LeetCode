class Solution20211124(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        reverse = 0
        xx = x
        if xx < 0:
            return False
        elif xx < 10:
            return True
        else:
            while xx:
                reverse = xx%10 + reverse*10
                xx = xx//10
            return x == reverse

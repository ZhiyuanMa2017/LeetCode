class Solution20211124(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        longestprefix=""
        if len(strs) > 1:
            for k in range(len(strs[0])):
                status = 0
                for j in range(1,len(strs)):
                    if strs[0][0:k+1] != strs[j][0:k+1]:
                        status = 1
                        break
                if status == 1:
                    break
                if status == 0:
                    if len(longestprefix) < len(strs[0][0:k+1]):
                        longestprefix = strs[0][0:k+1]
        elif len(strs) == 1:
            longestprefix = strs[0]
        return longestprefix

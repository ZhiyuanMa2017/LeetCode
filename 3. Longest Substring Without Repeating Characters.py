# class Solution(object):
#     def lengthOfLongestSubstring(self, s):
#         """
#         :type s: str
#         :rtype: int
#         """
#
#         substring = ''
#         length = 0
#         for i in range(len(s)):
#             if s[i] not in substring:
#                 substring = substring + s[i]
#                 if i == 0 or i == len(s) - 1:
#                     length = max(length, len(substring))
#             else:
#                 length = max(length, len(substring))
#                 index = substring.find(s[i])
#                 substring = substring[index + 1:] + s[i]
#         return length

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        substring = ''
        length = 0
        for i in s:
            if i in substring:
                substring = substring[substring.index(i)+1:]
            substring = substring + i
            length = max(length,len(substring))
        return length



# class Solution(object):
#     def twoSum(self, nums, target):
#         """
#         :type nums: List[int]
#         :type target: int
#         :rtype: List[int]
#         """
#         for i in range(len(nums)):
#                 for j in range(i+1, len(nums)):
#                     if nums[j] + nums[i] == target:
#                         return [i, j]

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        before = {}
        for i, num in enumerate(nums):
            subtraction = target - num
            if subtraction not in before:
                before[num] = i
            else:
                return [before[subtraction],i]
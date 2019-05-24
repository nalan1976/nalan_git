#Given an array nums, write a function to move all 0's
#to the end of it while maintaining the relative order of
# the non-zero elements.
# Input: [0,1,0,3,12]
# Output: [1,3,12,0,0]
class Solution(object):
    def moveZeroes(self, nums):
        for i in range(0, len(nums)):
            if nums[i] == 0:
                nums = nums[0: i] + nums[i + 1: len(nums) + 1]
                nums.append(0)
        print(nums)
        return nums
solu = Solution()
print(solu.moveZeroes([0,1,0,3,12]))
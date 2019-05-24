# Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
#
# Example:
# Given nums = [-2, 0, 3, -5, 2, -1]
#
# sumRange(0, 2) -> 1
# sumRange(2, 5) -> -1
# sumRange(0, 5) -> -3
class NumArray(object):
    nums2 = []
    def __init__(self, nums):
        self.nums2 = nums
    def sumRange(self, i, j):
        count = 0
        while i <= j:
            count += self.nums2[i]
            i += 1
        print(count)
        return count
obj = NumArray([-2, 0, 3, -5, 2, -1])
obj.sumRange(0,2)
obj.sumRange(2,5)
obj.sumRange(0,5)



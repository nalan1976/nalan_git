class Solution:
    def checkPossibility(self, nums):
        i = 0
        for var in range(1, len(nums)):
            if nums[var] < nums[var - 1]:
                i += 1
                if var - 2 < 0 or nums[var] >= nums[var - 2]:
                    nums[var - 1] = nums[var]
                else:
                    nums[var] = nums[var - 1]
            if i == 2:
                print(False)
                return False
        print(True)
        return True
solu = Solution()
solu.checkPossibility([-1, 4, 2, 3])
solu.checkPossibility([4, 2, 3])
solu.checkPossibility([2, 3, 3, 2, 4])
solu.checkPossibility([3, 4, 2, 3])
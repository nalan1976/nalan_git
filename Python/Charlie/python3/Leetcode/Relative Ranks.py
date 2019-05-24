class Solution:
    def findRelativeRanks(self, nums):
        mydict = dict()
        mydict2 = dict()
        for i in range(0, len(nums)):
            mydict[nums[i]] = i
        nums2 = nums.copy()
        nums2.sort()
        nums2.reverse()
        for i in range(0, len(nums2)):
            mydict2[nums2[i]] = i
        j = 3
        for i in range(0, len(nums)):
            if nums[i] != nums2[0] and nums[i] != nums2[1] and nums[i] != nums2[2]:
                nums[i] = str(mydict2[nums[i]] + 1)
        if len(nums) >= 3:
            if len(nums) == 3:
                nums[mydict[nums2[0]]] = "Gold Medal"
                nums[mydict[nums2[1]]] = "Silver Medal"
                nums[mydict[nums2[2]]] = "Bronze Medal"
                return nums
            else:
                nums[mydict[nums2[0]]] = "Gold Medal"
                nums[mydict[nums2[1]]] = "Silver Medal"
                nums[mydict[nums2[2]]] = "Bronze Medal"
        elif len(nums) == 2:
            nums[mydict[nums2[0]]] = "Gold Medal"
            nums[mydict[nums2[1]]] = "Silver Medal"
            return nums
        else:
            nums[mydict[nums2[0]]] = "Gold Medal"
            print(nums)
            return nums
        print(nums)
        return nums
solu = Solution()
solu.findRelativeRanks([5, 4, 3, 2, 1])
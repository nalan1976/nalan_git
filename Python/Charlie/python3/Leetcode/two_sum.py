num1 = [2, 7, 11, 15, 10, 9, 7, -4, 1, 0]
class Solution(object):
    def twoSum(self, nums, target):
        mylist = list()
        x = 0
        y = 1
        while nums[x] + nums[y] != target:
            if y == len(nums) - 1:
                x += 1
                y = x + 1
            else:
                y += 1
        mylist.append(x)
        mylist.append(y)
        print(mylist)
        return mylist
solu = Solution()
solu.twoSum(num1, -4)
class Solution(object):
    def maxArea(self, height):
        var1 = 0
        c = 0
        for i, j in range(0, len(height)), range(i + 1, len(height)):
            if height[j] >= height[i]:
                if var1 < c * height[i]:
                    var1 = c * height[i]
            else:
                if var1 < c * height[j]:
                     var1 = c * height[j]
            c += 1
        print(var1)
        return var1
solu = Solution()
solu.maxArea([2,3,4,5,18,17,6])
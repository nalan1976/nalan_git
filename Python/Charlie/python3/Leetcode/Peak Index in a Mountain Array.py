class Solution(object):
    def peakIndexInMountainArray(self, A):
        v = 0
        k = 0
        for i in range(0, len(A)):
            if A[i] > k:
                k = A[i]
                v = i
        print(v)
        return v
a = [3, 2, 1, 0]
solu = Solution()
solu.peakIndexInMountainArray(a)


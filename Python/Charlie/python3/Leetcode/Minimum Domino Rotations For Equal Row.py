class Solution(object):
    def minDominoRotations(self, A, B):
        num_B = 0
        num_A = 0
        start = A[0]
        start2 = B[0]
        for i in range(0, len(A) - 1):
            if A[i] == start or A[i] == start2:
                if A[i] != B[i]:
                    num_A += 1
            if B[i] == start or B[i] == start2:
                    num_B += 1
            else:
                print(-1)
                return -1
        print(min(num_A, num_B))
        return min(num_A, num_B)
solu = Solution()
# solu.minDominoRotations([2, 1, 2, 4, 2, 2], [5, 2, 6, 2, 3, 2])
# solu.minDominoRotations([3,5,1,2,3], [3,6,3,3,4])
solu.minDominoRotations([1,2,1,1,1,2,2,2], [2,1,2,2,2,2,2,2])

class Solution:
    def fib(self, N: int) -> int:
        if N == 0:
            return 0
        if N == 1:
            return 1
        return fib(N - 2) + fib(N - 1)
solu = Solution()
print(solu.fib(6))

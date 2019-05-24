"""
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
"""
class Solution(object):
    def arrangeCoins(self, n):
        if n == 1 or n == 2:
            print(1)
            return 1
        row_num = 0
        count = 0
        count2 = 0
        while True:
            count += row_num
            row_num += 1
            count2 += 1
            if n < count + row_num:
                print(count2 - 1)
                return count2 - 1
solu = Solution()
solu.arrangeCoins(5)
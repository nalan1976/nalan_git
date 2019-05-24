# You are given a map in form of a two - dimensional
# integer grid where 1 represents land and 0 represents water.
#
# Grid cells are connected horizontally / vertically(not diagonally).The
# grid is completely surrounded by water, and there is exactly one island(i.e., one or more connected land cells).
#
# The island doesn't have "lakes" (water inside that isn't connected
# to the water around the island).One cell is square
# with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
#
#
#
# Example:
#
#     Input:
#     [[0, 1, 0, 0],
# [1, 1, 1, 0],
# [0, 1, 0, 0],
# [1, 1, 0, 0]]
#
# Output: 16
class Solution(object):
    def islandPerimeter(self, grid):
        count = 0
        for i in range(0, len(grid)):
            for j in range(0, len(grid[i])):
                if grid[i][j] == 1:
                    count += 4
                    if j + 1 != len(grid[i]) and grid[i][j + 1] == 1:
                        count -= 2
                    if i + 1 < len(grid) and grid[i + 1][j] == 1:
                        count -= 2
        print(count)
        return count
solu = Solution()
solu.islandPerimeter([[0, 1, 0, 0],[1, 1, 1, 0],[0, 1, 0, 0],[1, 1, 0, 0]])

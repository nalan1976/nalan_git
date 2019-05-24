class Solution(object):
    def sortedSquares(self, A):
        mylist = list()
        for x in A:
            mylist.append(x * x)
        mylist.sort()
        print(mylist)
        return mylist
solu = Solution()
solu.sortedSquares([-2, 0, 5, 7])


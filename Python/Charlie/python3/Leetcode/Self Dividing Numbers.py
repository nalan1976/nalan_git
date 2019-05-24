class Solution(object):
    def selfDividingNumbers(self, left, right):
        mylist = list()
        for x in range(left, right + 1):
            y = str(x)
            for y_index in range(0, len(y)):
                if int(y[int(y_index)]) == 0:
                    break
                elif x % int(y[int(y_index)]) != 0:
                    break
                elif x % int(y[int(y_index)]) == 0 and int(y_index) == len(y) - 1:
                    mylist.append(x)
        print(mylist)
        return mylist
solu = Solution()
solu.selfDividingNumbers(1, 23)
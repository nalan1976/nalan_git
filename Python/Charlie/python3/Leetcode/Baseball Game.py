import re
class Solution(object):
    def calPoints(self, ops):
        mylist = list()
        pattern = re.compile(r'^[-+]?[-0-9]\d*\.\d*|[-+]?\.?[0-9]\d*$')
        for i in range(0, len(ops)):
            if pattern.match(ops[i]):
                mylist.append(int(ops[i]))
            elif ops[i] == "C" and len(mylist) != 0:
                mylist = mylist[0: len(mylist) - 1]
            elif ops[i] == "D" and len(mylist) != 0:
                mylist.append(int(mylist[len(mylist) - 1] * 2))
            elif ops[i] == "+" and len(mylist) >= 2:
                mylist.append(int(mylist[len(mylist) - 1] + mylist[len(mylist) - 2]))
        print(sum(mylist))
        return sum(mylist)
solu = Solution()
solu.calPoints(["5","2","C","D","+"])
solu.calPoints(["5","-2","4","C","D","9","+","+"])
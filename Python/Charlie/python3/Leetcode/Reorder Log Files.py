class Solution:
    def reorderLogFiles(self, logs):
        mylist = list()
        mylist2 = list()
        mylist4 = list()
        dt = {}
        for i in range(0, len(logs)):
            mylist3 = logs[i].split(" ")
            if ord(mylist3[1][0]) < 123 and ord(mylist3[1][0]) > 96:
                mylist.append(logs[i][logs[i].find(" ")+1:])
                dt[logs[i][logs[i].find(" ")+1:]] = mylist3[0]
            else:
                mylist2.append(logs[i])
        mylist.sort()
        for i in mylist:
            mylist4.append(dt[i] + " " + i)
        mylist4 += mylist2
        print(mylist4)
        return mylist4
solu = Solution()
solu.reorderLogFiles(["a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 aff key dog", "a8 act zoo"])

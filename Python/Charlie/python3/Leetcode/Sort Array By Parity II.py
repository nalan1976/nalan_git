class Solution:
    def sortArrayByParityII(self, A):
        mylist = list()
        mylist2 = list()
        mylist3 = list()
        x = 0
        y = 0
        for i in range(0, len(A)):
            if A[i] % 2 == 0:
                mylist2.append(A[i])
            else:
                mylist3.append(A[i])
        for i in range(0, len(A)):
            if i % 2 == 0:
                mylist.append(mylist2[x])
                x += 1
            else:
                mylist.append(mylist3[y])
                y += 1
        print(mylist)
        return mylist
solu = Solution()
solu.sortArrayByParityII([9, 8, 6, 3, 6, 8, 0, 9, 3, 1])
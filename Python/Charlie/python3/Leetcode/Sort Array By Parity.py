class Solution(object):
    def sortArrayByParity(self, A):
        list1 = list()
        list2 = list()
        for x in A:
            v = x % 2
            if v == 1:
                list2.append(x)
            else:
                list1.append(x)
        list1 = list1 + list2
        print(list1)
        return list1
solu = Solution()
solu.sortArrayByParity([0, 1, 2, 5, 8, 9, 7])
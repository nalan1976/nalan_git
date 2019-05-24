class Solution(object):
    def repeatedNTimes(self, A):
        mydict = dict()
        for number in A:
            if number in mydict.keys():
                mydict[number] += 1
            else:
                mydict[number] = 1
        for k, v in mydict.items():
            if v == len(A) / 2:
                print(k)
                return k
A = [2, 1, 3, 1, 1, 3]
solu = Solution()
solu.repeatedNTimes(A)

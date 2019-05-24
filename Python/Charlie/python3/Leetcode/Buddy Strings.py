class Solution:
    def buddyStrings(self, A, B):
        i = 0
        i2 = 0
        mydict = dict()
        var1 = 0
        var2 = 0
        var3 = ''
        if len(A) == 0:
            print(False)
            return False
        for j in range(0, len(A)):
            if A[j] == B[j]:
                mydict[A[j]] = 1
            else:
                i += 1
                mydict[A[j]] = 1
                if i == 1:
                    var1 = j
                elif i == 2:
                    var2 = j
            if i > 2:
                print(False)
                return False
        for j in mydict:
            i2 += 1
        if i2 < len(A) and i == 0:
            print(True)
            return True
        elif i == 0 and i2 == len(A):
            print(False)
            return False
        elif i == 2:
            if A[var1] == B[var2] and A[var2] == B[var1]:
                print(True)
                return True
            else:
                print(False)
                return False


solu = Solution()
solu.buddyStrings("ab", "ba")
solu.buddyStrings("ab", "ab")
solu.buddyStrings("aaaaabc", "aaaaacb")
solu.buddyStrings("aa", "aa")
solu.buddyStrings("", "aa")

solu.buddyStrings("abcaa", "abcbb")
solu.buddyStrings("", "")
solu.buddyStrings("ab", "ca")
solu.buddyStrings("abab", "abab")

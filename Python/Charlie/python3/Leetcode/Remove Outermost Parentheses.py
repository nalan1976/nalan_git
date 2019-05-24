class Solution(object):
    def removeOuterParentheses(self, S):
        mylist = ''
        v = 0
        x = 0
        for i in range(0, len(S)):
            if S[i] == "(":
                v += 1
            else:
                v -= 1
            if v == 0:
                if x == 0:
                    mylist += S[1: i]
                    x = i + 2
                else:
                    mylist += S[x: i]
                    x = i + 2
        print(mylist)
        return mylist
solu = Solution()
solu.removeOuterParentheses("(()()())")



class Solution(object):
    def backspaceCompare(self, S, T):
        index = 0
        while index < len(S):
            if S[index] == '#':
                if index >= 2:
                    S = S[0: index - 1] + S[index + 1:]
                    index -= 2
                else:
                    S = S[index + 1:]
                    index = -1
            index += 1
        index = 0
        while index < len(T):
            if T[index] == '#':
                if index >= 2:
                    T = T[0: index - 1] + T[index + 1:]
                    index -= 2
                else:
                    T = T[index + 1:]
                    index = -1
            index += 1
        if S == T:
            print(True)
            return True
        print(False)
        return False
solu = Solution()
#solu.backspaceCompare("a##c", "#a#c")
solu.backspaceCompare("xywrrmp", "xywrrmu#p")
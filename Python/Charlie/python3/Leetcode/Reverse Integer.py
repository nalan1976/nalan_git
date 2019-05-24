class Solution(object):
    def numJewelsInStones(self, J, S):
        num = 0
        j_idx = 0
        s_idx = 0

        while True:
            if s_idx == len(S):
                s_idx = 0
                if j_idx < len(J) - 1:
                    j_idx += 1
                else:
                    break
            if J[j_idx] == S[s_idx]:
                num += 1
            s_idx += 1

        print(num)
        return num
solu = Solution()
solu.numJewelsInStones("b", "aaAbbbb")
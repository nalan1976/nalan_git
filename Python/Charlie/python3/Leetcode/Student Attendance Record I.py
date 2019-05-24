class Solution(object):
    def checkRecord(self, s):
        """
        :type s: str
        :rtype: bool
        """
        i = 0
        for S in range(0, len(s)):
            if S <= len(s) - 3 and s[S] == 'L' and s[S + 1] == 'L' and s[S + 2] == 'L':
                print(False)
                return False
            if s[S] == 'A':
                i += 1
            if i == 2:
                print(False)
                return False
        print(True)
        return True
solu = Solution()
solu.checkRecord("PPALLP")
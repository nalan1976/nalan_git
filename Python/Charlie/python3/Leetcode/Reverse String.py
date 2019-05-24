class Solution(object):
    def reverseString(self, s):
        z = len(s)
        change = ''
        i = 0
        j = 0
        while z - j > i:
            change = s[i]
            s[i] = s[z - j - 1]
            s[z - j - 1] = change
            i += 1
            j += 1
        print(s)
        return s
solu = Solution()
solu.reverseString(["h", "e", "l", "l", "o", "s"])

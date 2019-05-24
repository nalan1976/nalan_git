class Solution:
    def findContentChildren(self, g, s):
        g = sorted(g)
        s = sorted(s)
        ch_num = 0
        count = 0
        for i in range(0, len(s)):
            if ch_num == len(g):
                break
            if s[i] >= g[ch_num]:
                count += 1
                ch_num += 1
        print(count)
        return count
solu = Solution()
solu.findContentChildren([1, 2, 3], [1, 1])
solu.findContentChildren([1, 2], [1, 2, 3])
solu.findContentChildren([1, 4], [1, 2, 3])
solu.findContentChildren([4, 3], [3, 3, 3])
solu.findContentChildren([1, 2], [3])
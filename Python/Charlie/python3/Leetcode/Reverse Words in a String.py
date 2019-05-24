class Solution(object):
    def reverseWords(self, s):
        mylist = s.split(' ')
        v = ''
        for i in mylist:
            for j in range(0, len(i)):
                v += i[(len(i) - j) - 1]
            v += ' '
        print(v)
        return v
solu = Solution()
solu.reverseWords("Let's take LeetCode contest")
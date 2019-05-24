class Solution(object):
    def judgeCircle(self, moves):
        mydict = {'U': 0, 'D': 0, 'L': 0, 'R': 0}
        for x in moves:
            mydict[x] += 1
        if mydict['U'] == mydict['D'] and mydict['L'] == mydict['R']:
            print('True')
            return True
        else:
            print('False')
            return False
solu = Solution()
solu.judgeCircle('UDL')
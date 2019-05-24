class Solution(object):
    def hammingDistance(self, x, y):
        # value_x = 0
        # value_y = 0
        # while True:
        #     if x % 2 == 0:
        #         x = x / 2
        #         value_x += 1
        #     else:
        #         value_x += 1
        #         break
        # while True:
        #     if y % 2 == 0:
        #         y = y / 2
        #         value_y += 1
        #     else:
        #         value_y += 1
        #         break
        # if value_x > value_y:
        #     print(value_x - value_y)
        #     return value_x - value_y
        # else:
        #     print(value_y - value_x)
        #     return value_y - value_x
        z = bin(x^y)
        print(z.count('1'))
        return z.count('1')
solu = Solution()
solu.hammingDistance(3, 1)
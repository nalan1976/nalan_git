class Solution(object):
    def maximumProduct(self, nums):
        nums.sort(reverse=True)
        a = nums[0]
        b = nums[1]
        c = nums[2]
        d = nums[len(nums) - 3]
        e = nums[len(nums) - 2]
        f = nums[len(nums) - 1]
        if a <= 0:
            print(a * b * c)
            return a * b * c
        elif b <= 0 or c <= 0:
            print(a * f * e)
            return a * f * e
        elif d >= 0:
            print(a * b * c)
            return a * b * c
        else:
            mylist = [a, b, c, d, e, f]
            print(max(mylist[0] * mylist[1] * mylist[2], mylist[0] * mylist[len(mylist) - 1] * mylist[len(mylist) - 2]))
            return max(mylist[0] * mylist[1] * mylist[2], mylist[0] * mylist[len(mylist) - 1] * mylist[len(mylist) - 2])
solu = Solution()
# solu.maximumProduct([4, 3, 2, 1, 0])
# solu.maximumProduct([5, 0, -1, -2, -3])
# solu.maximumProduct([0, -1, -2, -3, -5])
# solu.maximumProduct([1, 0, -1, -7, -9])
# solu.maximumProduct([99, 70, -2, -9, -10])
# solu.maximumProduct([2, 0, -1])
# solu.maximumProduct([4, 3, 2, -1, -2, -3])
# solu.maximumProduct([5, 4, 3, 2, 1, 0])
solu.maximumProduct([722,634,-504,-379,163,-613,-842,-578,750,951,-158,30,-238,-392
    ,-487,-797,-157,-374,999,-5,-521,-879,-858,382,626,803,-347,903,-205,57
    ,-342,186,-736,17,83,726,-960,343,-984,937,-758,-122,577,-595,-544,-559
    ,903,-183,192,825,368,-674,57,-959,884,29,-681,-339,582,969,-95,-455,-275
    ,205,-548,79,258,35,233,203,20,-936,878,-868,-458,-882,867,-664,-892,-687
    ,322,844,-745,447,-909,-586,69,-88,88,445,-553,-666,130,-640,-918,-7,-420
    ,-368,250,-786])
class Solution(object):
    def maximumProduct(self, nums):
        count = 0
        nums.sort(reverse=True)
        if nums[0] < 0:
            count = 3
        elif nums[1] < 0:
            count = 2
        elif nums[2] < 0:
            count = 1

        if count == 3 or count == 0:
            print(nums[0] * nums[1] * nums[2])
            return nums[0] * nums[1] * nums[2]
        elif count == 2:
            print(nums[0] * nums[len(nums) - 1] * nums[len(nums) - 2])
            return nums[0] * nums[len(nums) - 1] * nums[len(nums) - 2]
        elif nums[1] * nums[2] > abs(nums[len(nums) - 1]) * abs(nums[len(nums) - 2]):
            print(nums[0] * nums[1] * nums[2])
            return nums[0] * nums[1] * nums[2]
        else:
            print(nums[0] * nums[len(nums) - 1] * nums[len(nums) - 2])
            return nums[0] * nums[len(nums) - 1] * nums[len(nums) - 2]
solu = Solution()
solu.maximumProduct([722,634,-504,-379,163,-613,-842,-578,750,951,-158,30,-238,-392,-487,-797
    ,-157,-374,999,-5,-521,-879,-858,382,626,803,-347,903,-205,57,-342,186,-736,17,83,726,
 -960,343,-984,937,-758,-122,577,-595,-544,-559,903,-183,192,825,368,-674,57,-959,884,29,-681,-339,582,969,
 -95,-455,-275,205,-548,79,258,35,233,203,
 20,-936,878,-868,-458,-882,867,-664,-892,-687,322,844,-745,447,-909,-586,69,-88,88,445,-553,
 -666,130,-640,-918,-7,-420,-368,250,-786])

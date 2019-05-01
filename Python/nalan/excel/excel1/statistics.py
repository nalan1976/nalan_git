# import numpy

class Statistics:

    def find_mean(self, sample_list):
        ret = 0.0
        for i in sample_list:
            ret += i
        print("The Mean is : ", ret/len(sample_list))
        return ret/len(sample_list)

    def find_variance(self, u, sample_list):
        ret = 0.0
        for i in sample_list:
            ret += (i - u)**2
        print("The variance is : ", ret/len(sample_list))
        return ret/len(sample_list)

    def find_variance_s(self, u, sample_list):
        ret = 0.0
        for i in sample_list:
            ret += (i - u)**2
        print("The variance is : ", ret/(len(sample_list)-1))
        return ret/(len(sample_list)-1)

    def sstr(self, n, Xj_list, XX):
        ret = 0.0
        for i in Xj_list:
            ret += (i - XX)**2
        ret *= n
        print("The SSTR is : ", ret)
        return ret

    def sst(self, Xij_list, XX):
        ret = 0.0
        for i in Xij_list:
            ret += (i - XX)**2
        print("The SST is : ", ret)
        return ret

solu = Statistics()
solu.sstr(5, [55, 68, 57], solu.find_mean([55, 68, 57]))
solu.sst([48, 54, 57, 54, 62,
             73, 63, 66, 64, 74,
             51, 63, 61, 54, 56], solu.find_mean([55, 68, 57]))

# solu.find_variance(263.43, [228, 462, 352, 208, 224, 149, 221])
#
# solu.find_variance_s(2.7, [7, 6, 4, 1, 2, 3, -1, 2, -2, 5])



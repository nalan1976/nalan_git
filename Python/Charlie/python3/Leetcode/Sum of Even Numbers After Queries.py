class Solution(object):
    def sumEvenAfterQueries(self, A, queries):
        mylist = list()
        mylist2 = A.copy()
        app_list = 0
        app_list = sum([i for i in A if i % 2 == 0])

            #A[queries[i][1]] = A[queries[i][1]] + queries[i][0]
        for i in range(0, len(queries)):
            A[queries[i][1]] = A[queries[i][1]] + queries[i][0]
            if A[queries[i][1]] % 2 == 0:
                if mylist2[queries[i][1]] % 2 == 0:
                    app_list = app_list - mylist2[queries[i][1]] + A[queries[i][1]]
                else:
                    app_list = app_list + A[queries[i][1]]
                mylist.append(app_list)
            else:
                if mylist2[queries[i][1]] % 2 == 0:
                    app_list = app_list - mylist2[queries[i][1]]
                mylist.append(app_list)
            mylist2 = A.copy()
        print(mylist)
        return mylist
solu = Solution()
solu.sumEvenAfterQueries([1, 2, 3, 4], [[1, 0], [-3, 1], [-4, 0], [2, 3]])
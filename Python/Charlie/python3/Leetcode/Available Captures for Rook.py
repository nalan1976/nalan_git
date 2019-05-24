class Solution(object):
    def numRookCaptures(self, board):
        index_x = 0
        index_y = 0
        flag = False
        bring_p = 0
        for x in range(0, len(board)):
            for y in range(0, 8):
                if board[x][y] == "R":
                    index_x = x
                    index_y = y
                    flag = True
            if flag:
                break

        flag = False
        for i in range(index_y, 8):
            if board[index_x][i] == 'p':
                flag = True
                break
            if board[index_x][i] == 'B':
                break

        if flag == True:
            bring_p += 1
        flag = False

        for i in range(0, index_y):
            if board[index_x][index_y - i] == 'p':
                flag = True
                break
            if board[index_x][index_y - i] == 'B':
                break
        if flag == True:
            bring_p += 1
        flag = False
        for i in range(0, index_x):
            if board[index_x - i][index_y] == 'p':
                flag = True
                break
            if board[index_x - i][index_y] == 'B':
                break
        if flag == True:
            bring_p += 1
        flag = False
        for i in range(index_y, 8):
            if board[i][index_y] == 'p':
                flag = True
                break
            if board[i][index_y] == 'B':
                break
        if flag == True:
            bring_p += 1
        print(bring_p)
        return bring_p
solu = Solution()
solu.numRookCaptures([[".",".",".",".",".",".",".","."]
                    ,[".",".",".","p",".",".",".","."]
                    ,[".","p","B","R",".",".",".","p"]
                    ,[".",".",".",".",".",".",".","."]
                    ,[".",".",".",".",".",".",".","."]
                    ,[".",".",".","p",".",".",".","."]
                    ,[".",".",".",".",".",".",".","."]
                    ,[".",".",".",".",".",".",".","."]])
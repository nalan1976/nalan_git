import copy
cubes = [1, 8, 27, 65, 125]
cubes[3] = 64  # 修改列表值
print(cubes)
cubes.append(216)  # cube列表中添加新值
cubes.append(73)  # cube列表中添加第七个值
print(cubes)

letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g']
# 替换一些值
letters[2:5] = ['C', 'D', 'E']
print(letters)
# 移除值
letters[2:5] = []
print(letters)
# 清除列表
letters[:] = []
print(letters)
letters = ['a', 'b', 'c', 'd']
print(len(letters))

a = ['a', 'b', 'c']
n = [1, 2, 3]
x = [a, n]
print(x)

list1 = [1,2,3]
list2 = list1
list2[2] = 0
print(list2)
print(list1)

list1 = [1,2,3]
list2 = list1.copy()
list1[0] = 0
print(list2)
print(list1)

list1 = [[4,5,6],2,3]
list2 = list1.copy()
list1[0][0] = 0
print(list2)
print(list1)

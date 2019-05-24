var1 = "My name is Charlie. "
print(var1)
x = 0
y = 0
z = 0
while z < len(var1):
	if var1[z] == " ":
		y = z
		print(var1[x:y])
		x = z + 1
	z += 1

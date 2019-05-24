tuplea = ("a", 1, "b")
print(tuplea)
print(tuplea[1])
appleb = tuplea +(1, 2, 3, 4, 5)
print(appleb)
for letter in 'Python':
	print('letter :', letter)
for number in range(0,5):
	print('number :',number)
for letter in appleb:
	print(letter)
	
for l in range(0,len(appleb)):
	print(appleb[l])
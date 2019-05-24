import csv
with open("words_sheet.csv") as sheet:
	d = dict()
	sheet2 = csv.reader(sheet)
	#print(sheet2)
	for rang in sheet2:
		#print(rang)
		print(rang[1])
		apple = input("a means 'correct',d means 'incorrect',\
 and enter means next.")
		print(apple)
		if "a" == apple:
			print("correct")
			print(rang[12])
		elif "d" == apple:
			print("incorrect")
			print(rang[12])
		else:
			print("invalid input and incorrect")
			print(rang[12])



import csv
with open("words_sheet.csv") as sheet:
	#d = dict()
	sheet2 = csv.reader(sheet)
	#print(sheet2)
	number_a = 0
	number_d = 0
	dict_hardwords = dict()
	for rang in sheet2:
		#print(rang)
		print(rang[1])
		apple = input("a means 'correct',d means 'incorrect',\
 and enter means next.")
		print(apple)
		if "a" == apple:
			print("correct")
			print(rang[12])
			number_a = number_a + 1
		elif "d" == apple:
			print("incorrect")
			print(rang[12])
			number_d += 1
			dict_hardwords[rang[1]] = rang[12]
		else:
			print("invalid input and incorrect")
			print(rang[12])
	print("correct number is :",str(number_a))
	print("incorrect number is :",str(number_d))
	print(dict_hardwords)
with open('Hard_words_sheet.csv', 'a+') as hardw:
    # write = csv.writer(hardw)
    write = csv.writer(hardw, delimiter=",", quotechar=" ")
    # for row in dict_hardwords.keys():
    # write.writerows(dict_hardwords)
    print(dict_hardwords.keys())
    for key in dict_hardwords.keys():
        data = ""+ key + ":" + str(dict_hardwords.get(key)) + "\n"
        hardw.write(data)

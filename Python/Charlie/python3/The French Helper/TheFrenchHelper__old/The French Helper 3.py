import csv
with open("words_sheet.csv") as sheet:
	#d = dict()
	sheet2 = list(csv.reader(sheet))
	rang = 0
	#print(sheet2)
	number_a = 0
	number_d = 0
	dict_hardwords = dict()
	while rang < len(sheet2):
		#print(rang)
		print(sheet2[rang][1])
		apple = input("a means 'correct',d means 'incorrect',\
 w means last word,and enter means next.")
		print(apple)
		if "a" == apple:
			print("correct")
			print(sheet2[rang][12])
			number_a = number_a + 1

		elif "d" == apple:
			print("incorrect")
			print(sheet2[rang][12])
			number_d += 1
			dict_hardwords[sheet2[rang][1]] = sheet2[rang][12]
		elif "w" == apple:
			if rang > 0:
				rang -= 2
		else:
			print("invalid input and incorrect")
			rang -= 1
		rang += 1
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

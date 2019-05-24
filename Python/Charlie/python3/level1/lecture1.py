import csv
agg_cnt = dict()
with open('e://MyCode//BigDataCourse//big_data_course//Level-I//lecture1//transactions.csv', 'r') as csvFile:
    # reader = csv.reader(csvFile)
    print(csvFile)
    reader = csv.reader(csvFile, delimiter=',',  quotechar=' ')
    print(reader)
    for row in reader:
    	# desRow
    	if(agg_cnt.get(row[1]) == None):
    		agg_cnt[row[1]] = int(row[2])
    	else:
    		agg_cnt[row[1]] = agg_cnt.get(row[1]) + int(row[2])

    print(agg_cnt)

with open('output.csv', 'w') as opFile:
    # write = csv.writer(opFile)
    write = csv.writer(opFile, delimiter=",", quotechar=" ")
    # for row in agg_cnt.keys():
    # write.writerows(agg_cnt)
    print(agg_cnt.keys())
    for key in agg_cnt.keys():
        data = ""+ key + ":" + str(agg_cnt.get(key)) + "\n"
        opFile.write(data)

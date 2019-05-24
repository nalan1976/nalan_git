import csv
with open("transactions.csv") as document:
	k = dict()
	#print(document)
	document2 = csv.reader(document)
	#print(document2)
	for u in document2:
		#print(u)
	#print(k)
		if u[1] in k.keys():
			k[u[1]] = k[u[1]]+ int(u[2])
		else:
			k[u[1]] = int(u[2]) 
	print(k) 
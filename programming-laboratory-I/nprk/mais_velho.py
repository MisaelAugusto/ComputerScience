nome1 = raw_input()
dia1 = int(raw_input())
mes1 = int(raw_input())
ano1 = int(raw_input())
nome2 = raw_input()
dia2 = int(raw_input())
mes2 = int(raw_input())
ano2 = int(raw_input())

if ano1 == ano2:
	if mes1 == mes2:
		if dia1 == dia2:
			print "nenhuma"
		else:
			if dia1 > dia2:
				print nome2
			else:
				print nome1
	else:
		if mes1 > mes2:
			print nome2
		else:
			print nome1
else:
	if ano1 > ano2:
		print nome2
	else:
		print nome1

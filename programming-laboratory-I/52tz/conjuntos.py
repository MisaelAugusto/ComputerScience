# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Conjuntos Maiores

limite = int(raw_input())
conjuntos = int(raw_input())
total = 0
totais = []
while conjuntos > 0:
	numero = int(raw_input())
	if numero < 0:
		totais.append(total)
		conjuntos -= 1
		total = 0
	else:
		total += numero

for i in range(len(totais)):
	if totais[i] > limite:
		print "conjunto %d: %d" % (i + 1, totais[i])

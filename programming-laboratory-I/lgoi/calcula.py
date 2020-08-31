# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Calcula DV

numero = raw_input()
soma_par = 0
soma_impar = 0

for i in range(len(numero)):
	if i % 2 == 0:
		soma_par += int(numero[i])
	else:
		soma_impar += int(numero[i])

total = (soma_par * soma_impar) % 11
if total == 10:
	print "%s-X" % numero
else:
	print "%s-%d" % (numero, total)

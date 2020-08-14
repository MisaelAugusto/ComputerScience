# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Quantas PAs ?

razao = int(raw_input())

numero_pas = 0
while True:
	pa = 0
	sequencia = raw_input().split()
	if sequencia[0] == "fim":
		break
	for i in range(len(sequencia) - 1, 0, -1):
		diferenca = int(sequencia[i]) - int(sequencia[i - 1])
		if diferenca == razao:
			pa += 1
		else:
			break
	if pa == (len(sequencia) - 1):
		numero_pas += 1

print numero_pas

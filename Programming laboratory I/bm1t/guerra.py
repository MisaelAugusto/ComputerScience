# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Guerra Baralho

vitoria1 = 0
vitoria2 = 0
empate = 0
while True:
	numeros = raw_input().split()
	if numeros == ["0", "0"]:
		break
	else:
		if int(numeros[0]) > int(numeros[1]):
			vitoria1 += 1
		elif int(numeros[0]) < int(numeros[1]):
			vitoria2 += 1
		else:
			empate += 1

print "Jogador 1: %d, Jogador 2: %d, Empates: %d" % (vitoria1, vitoria2, empate)

# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Bingo

cartela1 = raw_input().split()
cartela2 = raw_input().split()

pontos1 = 0
pontos2 = 0
while True:
	numero = int(raw_input())
	for i in range(len(cartela1)):
		if int(cartela1[i]) == numero:
			pontos1 += 1
		if int(cartela2[i]) == numero:
			pontos2 += 1
	if pontos1 == len(cartela1) or pontos2 == len(cartela2):
		if pontos1 > pontos2:
			print "Bingo! Jogador 1 venceu."
		elif pontos1 < pontos2:
			print "Bingo! Jogador 2 venceu."
		else:
			print "Empate."
		break

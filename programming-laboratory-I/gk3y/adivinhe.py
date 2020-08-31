# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Adivinhe o número

import random

num_sorteado = int(raw_input())

tentativas = 0
while True:
	palpite = int(raw_input("palpite? "))
	tentativas += 1
	if palpite > num_sorteado:
		print "alto"
	elif palpite < num_sorteado:
		print "baixo"
	else:
		print "Você acertou em %d tentativas." % (tentativas)
		break

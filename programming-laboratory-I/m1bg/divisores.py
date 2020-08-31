# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Divisores Próprios

numero = int(raw_input())

for i in range(1, numero):
	if numero % i == 0:
		print i

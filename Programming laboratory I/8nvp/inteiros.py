# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Inteiros Positivos Divisíveis

A = int(raw_input())
B = int(raw_input())
K = int(raw_input())

for i in range(1, K + 1):
	if i % A == 0 and i % B == 0:
		print i

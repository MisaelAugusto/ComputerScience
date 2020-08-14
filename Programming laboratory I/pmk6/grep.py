# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Grep

palavra_chave = raw_input()
N = int(raw_input())

for i in range(N):
	frase = raw_input()
	for j in range(len(frase) - 2):
		palavra = frase[j] + frase[j + 1] + frase[j + 2]
		if palavra == palavra_chave:
			print frase
			break

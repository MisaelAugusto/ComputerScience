# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Quantidade de Inteiros Divisíveis por K

K = int(raw_input())
N = int(raw_input())

div = 0
for i in range(N):
	numero = int(raw_input())
	if numero % K == 0:
		div += 1
		

print "%d (%.1f%%)" % (div, div * 100.0 / N)

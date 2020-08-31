# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Quantidade e Média de Números Pares

N = int(raw_input())

soma = 0
n = 1
numeros = []
for i in range(N):
	numero = int(raw_input())
	if numero % 2 == 0:
		soma += numero
		media = (soma * 1.0) / n
		n += 1
	numeros.append(numero)

abaixo = 0
for i in numeros:
	if i < media:
		abaixo += 1	
print "soma: %d" % soma
print "média: %.1f" % media
print "%d número(s) abaixo da média" % abaixo

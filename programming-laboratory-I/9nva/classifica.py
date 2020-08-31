# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Classifica Números pelo Menor dos Extremos

N = int(raw_input())

numeros = []
for i in range(N):
	numero = int(raw_input())
	numeros.append(numero)

acima = 0
abaixo = 0
if numeros[0] > numeros[-1]:
	print "Menor dos extremos: %d" % numeros[-1]
	for i in range(N - 1):
		if numeros[i] > numeros[-1]:
			acima += 1
		elif numeros[i] < numeros [-1]:
			abaixo += 1
		else:
			continue
else:
	print "Menor dos extremos: %d" % numeros[0]
	for i in range(1, N):
		if numeros[i] > numeros[0]:
			acima += 1
		elif numeros[i] < numeros[0]:
			abaixo += 1
		else:
			continue
print "%d número(s) abaixo do menor" % abaixo
print "%d número(s) acima do menor" % acima

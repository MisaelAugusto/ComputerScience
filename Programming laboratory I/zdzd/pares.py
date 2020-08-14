# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Pares de Múltiplos

numeros = raw_input().split()
fator = float(raw_input())

par = 0
pares = []
for i in range(len(numeros) - 1):
	numero = int(numeros[i]) * fator
	numero2 = int(numeros[i + 1]) * fator
	if numero == int(numeros[i + 1]) or numero2 == int(numeros[i]):
		par += 1
		pares += [numeros[i], numeros[i + 1]]
		
print "%d par(es)" % par

for i in range(0, len(pares) - 1, 2):
	print "%s %s" % (pares[i], pares[i + 1])

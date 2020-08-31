# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Soma dos Últimos Ímpares

N = int(raw_input())
limite = int(raw_input())

numeros = []
for i in range(N):
	numero = int(raw_input())
	numeros.append(numero)
	
soma = 0
for i in range(len(numeros) - 1, - 1, - 1):
	if (numeros[i] % 2) != 0:
		if (soma + numeros[i]) < limite:
			soma += numeros[i]
		else:
			break
print soma

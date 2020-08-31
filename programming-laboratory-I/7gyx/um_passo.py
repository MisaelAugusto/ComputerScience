# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Um Passo do Algoritmo BubbleSort

while True:
	numeros = raw_input().split()
	if numeros[0] == "fim":
		break
	else:
		numero = ""
		for i in range(len(numeros) - 1):
			if int(numeros[i]) > int(numeros[i + 1]):
				numeros[i], numeros[i + 1] = numeros[i + 1], numeros[i]
			numero += numeros[i] + " "
		numero += numeros[-1]
		print numero

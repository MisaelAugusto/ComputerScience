# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Remove Palavras com Letras Iguais Consecutivas

def remove_consecutivas(lista):
	for i in range(len(lista) - 1, -1, -1):
		for j in range(len(lista[i]) - 1):
			if lista[i][j].lower() == lista[i][j + 1].lower():
				lista.pop(i)
				break

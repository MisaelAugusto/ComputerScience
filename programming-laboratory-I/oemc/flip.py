# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Flip

def flip(lista, i, j):
	tamanho = (j + 1 - i) / 2
	n = 0
	for k in range(tamanho):
		lista[i], lista[j - n] = lista[j - n], lista[i]
		i += 1
		n += 1

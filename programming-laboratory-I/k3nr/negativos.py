# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Negativos no fim

def negativos_no_fim(lista):
	n = len(lista) - 1
	for i in range(len(lista) - 1, -1, -1):
		if lista[i] < 0:
			lista[i], lista[n] = lista[n], lista[i]
			n -= 1

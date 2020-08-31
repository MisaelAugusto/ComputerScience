# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Remove os n últimos divisores de k

def remove_divisores_k(lista, k, n):
	N = 0
	i = len(lista) - 1
	while i >= 0 and N < n:
		if k % lista[i] == 0:
			lista.pop(i)
			N += 1
		i -= 1

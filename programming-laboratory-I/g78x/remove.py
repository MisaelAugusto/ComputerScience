# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Remove Números Opostos Adjacentes

def anula(lista):	
	n = len(lista) - 1
	i = n
	while i > 0:
		if lista[i] + lista[i - 1] == 0:
			lista.pop(i)
			lista.pop(i - 1)
			if i == n:
				i -= 2
			else:
				i -= 1
		else:
			i -= 1

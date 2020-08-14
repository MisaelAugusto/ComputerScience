# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Make Set

def make_set(lista):
	if len(lista) > 1:	
		for i in range(len(lista) - 1, 0, -1):
			for j in range(i - 1, -1, -1):
				if lista[i] == lista[j]:
					lista.pop(i)
					break
	return lista
	
print make_set([2, 2, 2])
	

# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Inserção ordenada do primeiro elemento de uma lista

def insere_ordenado_primeiro(lista):
	for i in range(1, len(lista)):
		for j in range(len(lista) - 1):
			if lista[j] > lista[j + 1]:
				lista[j], lista[j + 1] = lista[j + 1], lista[j]
	return lista

l1 = [5,2,6,9,11,13]
print insere_ordenado_primeiro(l1)


l2 = [3,1,2,4]
print insere_ordenado_primeiro(l2)

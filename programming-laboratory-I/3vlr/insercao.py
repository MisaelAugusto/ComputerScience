# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Inserção ordenada do último elemento de uma lista

def insere_ordenado_ultimo(lista):
	for i in range(len(lista) - 1, 0, -1):
		if lista[i] < lista[i - 1]:
			lista[i], lista[i - 1] = lista[i - 1], lista[i]
		else:
			break
	
	return lista

l1 = [2,6,9,11,13,5]
print insere_ordenado_ultimo(l1)


l2 = [1,2,3,0]
print insere_ordenado_ultimo(l2)

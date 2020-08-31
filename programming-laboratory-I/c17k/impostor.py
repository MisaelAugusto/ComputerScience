# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Insere Ordenado Impostor

def insere_ordenado_impostor(lista):
	for i in range(len(lista) - 1):
		if lista[i] > lista[i + 1]:
			posicao = i
			break
	for i in range(posicao + 1, 0, -1):
		if lista[i] < lista[i - 1]:
			lista[i], lista[i - 1] = lista[i - 1], lista[i]

	return lista

print insere_ordenado_impostor([1, 2, 4, 3, 5, 6, 7, 11])
print insere_ordenado_impostor([1, 9, 11, 3, 14])

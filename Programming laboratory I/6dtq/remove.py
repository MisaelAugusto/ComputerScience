# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Remove Maiores

def remove_maiores(lista):
	if len(lista) > 0:	
		maior = lista[0]
		for i in range(1, len(lista)):
			if maior < lista[i]:
				maior = lista[i]
		
		for i in range(len(lista) - 1, -1, -1):
			if lista[i] == maior:
				lista.pop(i)

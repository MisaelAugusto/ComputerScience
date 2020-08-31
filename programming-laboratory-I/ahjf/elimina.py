# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Elimina Menores

def elimina_menores(num, lista):
	removidos = 0
	for i in range(len(lista) - 1, -1, -1):
		if lista[i] < num:
			lista.pop(i)
			removidos += 1
	
	return removidos

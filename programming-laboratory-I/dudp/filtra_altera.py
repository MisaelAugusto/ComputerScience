# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Filtrando ELementos e Alterando uma Lista

def filtra_altera_lista(num, lista):
	for i in range(len(lista) -1, -1, -1):
		if i % num > 0:
			lista.pop(i)
	

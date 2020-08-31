# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Busca Linear

def busca(seq, valor):
	inicia = True
	for i in range(len(seq)):
		if seq[i] == valor:
			indice = i
			inicia = False
			break
	
	if inicia:
		indice = -1
	
	return indice

# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Insere na Posição Indicada

def na_posicao(lista, a_inserir):
	for par in a_inserir:
		lista.append(par[0])
		for i in range(len(lista) - 1, par[1], -1):
			lista[i], lista[i - 1] = lista[i - 1], lista[i]
	

# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Troca Chave

def troca_chave(dic):
	dic2 = {}
	for chave in dic:
		dic2[dic[chave]] = chave
	
	return dic2

print troca_chave({1:2, 2:3, 3:4})

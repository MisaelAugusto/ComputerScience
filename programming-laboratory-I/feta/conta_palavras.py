# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Conta Palavras

def conta_palavras(k, palavras):
	palavras = palavras.split(":")
	quantidade = 0
	for palavra in palavras:
		if len(palavra) >= k:
			quantidade += 1
	
	return quantidade

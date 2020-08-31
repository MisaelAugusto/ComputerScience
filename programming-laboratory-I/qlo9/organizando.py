# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Organizando as Duplas do Projeto

def insere_nome(aluno1, duplas, aluno2):
	inicia = False
	for i in range(len(duplas)):
		if aluno2 == duplas[i]:
			posicao = i
			inicia = True
			break
	
	duplas.append(aluno1)
	if inicia:
		for i in range(len(duplas) - 1, posicao, -1):
			duplas[i], duplas[i - 1] = duplas[i - 1], duplas[i]

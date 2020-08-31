# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Questões para mt

def seleciona_questoes(todas, utilizadas):
	for questao in utilizadas:
		for i in range(len(todas) -1, -1, -1):
			if questao == todas[i]:
				todas.pop(i)
				break
	
	return todas
	
print seleciona_questoes([1, 2, 3, 4, 5], [3, 4])

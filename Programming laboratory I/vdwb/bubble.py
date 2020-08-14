# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Bubblesort

def bubblesort(dados):
	update = True
	j = 0
	while j < len(dados) - 1 and update:
		update = False
		for i in range(len(dados) - 1):	
			if dados[i] > dados[i + 1]:
				dados[i], dados[i + 1] = dados[i + 1], dados[i]
				update = True
		j += 1
	return dados

# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Série (ímpare 1)

for i in range(1, 102, 2):
	if (i % 3 == 0) or (i % 5 == 0):
		i = "*"
	print i 
		

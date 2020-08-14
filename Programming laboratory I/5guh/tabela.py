# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Tabela de Quadrados

X = int(raw_input())
Y = int(raw_input())

if X > Y:
	print "---"
else:
	for i in range(X, Y + 1):
		print i, i**2

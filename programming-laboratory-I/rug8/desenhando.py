# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Desenhando uma Árvore de Natal

altura = int(raw_input())

for i in range(altura, 0, -1):
	print (" " * (i - 1)) + "o" + ("o" * (altura - i)) * 2
	


print " " * (altura - 1) + "o"

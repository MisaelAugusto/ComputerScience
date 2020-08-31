# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Ano Bissexto

ano = int(raw_input())

condicao1 = ano % 400 == 0
condicao2 = ano % 4 == 0 and ano % 100 > 0
if condicao1 or condicao2:
	print "%i é bissexto" % ano
else:
	print "%i não é bissexto" % ano

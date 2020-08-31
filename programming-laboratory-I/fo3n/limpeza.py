# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Limpeza

servico = int(raw_input())

if servico == 1:
	tamanho = int(raw_input())
	preco = 80 * tamanho
elif servico == 2:
	tamanho = int(raw_input())
	preco = 50 * tamanho
else:
	preco = 50

print "R$ %i,00" % preco

if preco >= 200:
	print "Brinde!"

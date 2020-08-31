# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Encontra Elemento

N = int(raw_input())

sequencia = raw_input().split()

nao = True
for numero in sequencia:
	if int(numero) == N:
		nao = False
		print "sim"
		break

if nao:
	print "não"

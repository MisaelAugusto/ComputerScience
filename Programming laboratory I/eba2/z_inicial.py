# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Z Inicial

def z_inicial(lista):
	n = 0
	for palavra in lista:
		if palavra[0].lower() == "z":
			n += 1
	
	return n

lista = raw_input().split()

print z_inicial(lista)

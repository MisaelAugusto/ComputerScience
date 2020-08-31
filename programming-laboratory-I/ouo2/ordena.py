# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Ordena Tipos

def ordena_tipos(lista):
	lista2 = []
	for caractere in lista:
		if str.isdigit(caractere):
			lista2.append(caractere)
	for caractere in lista:
		if str.isalpha(caractere):
			lista2.append(caractere)
	for caractere in lista:
		if not(str.isdigit(caractere)) and not((str.isalpha(caractere))):
			lista2.append(caractere)
	
	return lista2

print ordena_tipos(["1a", "2", "e", "4", "4.4", "e6", "8"])

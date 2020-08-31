# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Agrupa Pares

def agrupa_pares_impares(lista):
	dic = {}
	pares = []
	impares= []
	for numero in lista:
		if numero % 2 == 0:
			pares.append(numero)
		else:
			impares.append(numero)
	
	dic["pares"] = pares
	dic["impares"] = impares
	
	return dic
	

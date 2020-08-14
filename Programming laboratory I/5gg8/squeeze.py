# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Squeeze

def squeeze(lista):
	if len(lista) > 1:	
		for i in range(len(lista) - 1, 0, -1):
			if lista[i] == lista[i - 1]:
				lista.pop(i)
	
	return lista

print squeeze([0, 0, 0])

# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Organiza Lista pela Média

def organiza_por_media(lista):
	if len(lista) > 1:	
		acima = []
		media = 0
		for i in range(len(lista)):
			media += float(lista[i])
		
		media /= len(lista)

		for i in range(len(lista) - 1, -1, -1):
			if lista[i] > media:
				acima.append(lista[i])
				lista.pop(i)
		
		for i in range(len(acima) - 1, -1, -1):
			lista.append(acima[i])
	
	return lista
	
print organiza_por_media([1, 2, 4, 1, 3, 4, 56, 7, 7, 4, 3, 67])
print organiza_por_media([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
print organiza_por_media([])

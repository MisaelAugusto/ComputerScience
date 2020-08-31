# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: MinMax Sort = Selection Sort Duplicado

def minmax_sort(lista):
	lista_final = []	
	n = 0
	imin = 0
	imax = 0
	while n < len(lista) / 2:
		for i in range(n, len(lista) - n):
			if lista[i] < lista[imin]:
				imin = i
			if lista[i] > lista[imax]:
				imax = i
				
		lista[imin], lista[n] = lista[n], lista[imin]
		lista[imax], lista[len(lista) - 1 - n] = lista[len(lista) - 1 - n], lista[imax]
		lista2 = []
			
		for j in range(len(lista)):
			lista2.append(lista[j])

		lista_final.append(lista2)
			
		n += 1
		
	return lista_final	

print minmax_sort([7])
			

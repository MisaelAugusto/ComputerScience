# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Quantos Comeram ?

def quantos_comeram(N, fila):
	consumidas = 0
	for i in range(len(fila)):
		if consumidas + fila[i] > N:
			break
		else:
			consumidas += fila[i]
			
	return consumidas
			
		

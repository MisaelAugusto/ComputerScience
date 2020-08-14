# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Colegas de Sala!

def colegas_de_sala(salasprofs, professor):
	lista = []
	for prof in salasprofs:
		if prof != professor and salasprofs[prof] == salasprofs[professor]:
			lista.append(prof)
	
	return lista

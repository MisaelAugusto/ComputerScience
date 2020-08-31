# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Seleciona Divisores em uma Lista

def filtra_divisores(lista):
	for i in range(len(lista) - 1, -1, -1):
		somatorio = 0
		numero = str(lista[i])
		for digito in numero:
			somatorio += int(digito)
		if lista[i] % somatorio > 0:
			lista.pop(i)

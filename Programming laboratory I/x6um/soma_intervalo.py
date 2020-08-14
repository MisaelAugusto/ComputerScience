# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Soma Intervalo

def soma_intervalo(a, b):
	soma = a
	n = 1
	for i in range(b - a):
		soma += a + n
		n += 1
	return soma
	
print soma_intervalo(5, 15)

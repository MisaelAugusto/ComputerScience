# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Valor polinômio

def valor_polinomio(polinomio, valor):
	resultado = 0
	for i in range(len(polinomio)):
		resultado += (polinomio[i] * valor ** i)

	return resultado

print valor_polinomio([-5, 0, 2, 0, 3], 10)
print valor_polinomio([-5, 0, 2, 0, 3], 2)
print valor_polinomio([-5, 0, 2, 0, 3], 0)

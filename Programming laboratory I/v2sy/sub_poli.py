# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Subtração de Polinomios

def subtrai_polinomios(p1, p2):
	resultados = []
	i = 0
	while True:
		if i < len(p1) and i < len(p2):
			resultado = p1[i] - p2[i]
		elif i >= len(p1) and i < len(p2):
			resultado = p2[i] * (-1)
		elif i < len(p1) and i >= len(p2):
			resultado = p1[i]
		else:
			break

		resultados.append(resultado)
		
		i += 1
		
	for i in range(len(resultados) - 1, -1, -1):
		if resultados[i] == 0:
			resultados.pop(i)
		else:
			break

	return resultados
	
print subtrai_polinomios([-5, 4, 3], [-1, 0, 2, 0, 0, 0, 5])
print subtrai_polinomios([-5, 4, 3], [-4, 2, 3])
print subtrai_polinomios([6, 8, 3, 0, 1], [0, 3, 0, 0, -3])
	

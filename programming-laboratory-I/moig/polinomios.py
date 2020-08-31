# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Aplicação de Polinômios

polinomios = []
resultados = []
while True:
	entrada = raw_input().split()
	if entrada[0] == "fim":
		break
	else:
		if entrada[0] == "p:":
			entrada.pop(0)
			polinomios.append(entrada)
			resultados.append("novo polinomio")
		else:
			resultado = 0
			for i in range(len(polinomios[-1])):
				resultado +=  int(polinomios[-1][i]) * int(entrada[0]) ** i
			resultados.append(resultado)
				
for resultado in resultados:
	print resultado			
	

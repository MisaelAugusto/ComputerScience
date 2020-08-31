# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Calculadora

resultados = []
while True:
	entrada = raw_input().split()
	if entrada[0] == "5":
		break
	elif entrada[0] == "1":
		resultado = int(entrada[1]) + int(entrada[2])
	elif entrada[0] == "2":
		resultado = int(entrada[1]) - int(entrada[2])
	elif entrada[0] == "3":
		resultado = int(entrada[1]) * int(entrada[2])
	else:
		if entrada[2] == "0":
			resultado = "Erro: Divisão por 0"
		else:
			resultado = int(entrada[1]) / int(entrada[2])
	resultados.append(resultado)

for r in resultados:
	print r

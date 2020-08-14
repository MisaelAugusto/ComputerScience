# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Peso Ideal com Função

def calculaPeso(sexo, altura):
	if sexo == "m" or sexo == "M":
		peso_ideal = 72.7 * altura - 58
		print "Homem: peso ideal é %.1f" % peso_ideal
	else:
		peso_ideal = 62.1 * altura - 44.7
		print "Mulher: peso ideal é %.1f" % peso_ideal

while True:
	entrada = raw_input().split()
	if entrada[0] == "****":
		break
	else:
		calculaPeso(entrada[0], float(entrada[1]))



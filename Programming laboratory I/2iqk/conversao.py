# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: COnversão de Número na Base 2 para a Base 10

numero = raw_input()

decimal = 0
for i in range(len(numero)):
	potencia = 2 ** (len(numero) - 1 - i)
	num_dec = int(numero[i]) * potencia
	print "%s * %d = %d" % (numero[i], potencia, num_dec)
	decimal += num_dec
print "%s(2) = %d(10)" % (numero, decimal)


	

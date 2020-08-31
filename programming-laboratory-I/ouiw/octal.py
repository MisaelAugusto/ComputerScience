# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Convertendo um Número Octal em um Número Decimal

numero = raw_input()
numero_decimal = 0
for i in range(len(numero) - 2, -1, -1):
	resultado = int(numero[len(numero) - i]) * 8 ** (i + 1)
	print "%s * 8^%d = %d" % (numero[len(numero) - i], i, resultado)
	numero_decimal += resultado
	
print "%s(8) = %d(10)" % (numero, numero_decimal)

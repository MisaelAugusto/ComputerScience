# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Custo INSS

valor_salario = float(raw_input())
salario_empregador = valor_salario * 0.12
salario_empregado1 = valor_salario * 0.08
salario_empregado2 = valor_salario * 0.09
salario_empregado3 = valor_salario * 0.11

print "O valor da contribuição do INSS a ser pago pelo empregador é de R$ %.2f" % salario_empregador

if valor_salario <= 1317.07:
	print "O valor da contribuição do INSS a ser pago pelo empregado é de R$ %.2f" % salario_empregado1
elif 1317.07 < valor_salario <= 2195.12:
	print "O valor da contribuição do INSS a ser pago pelo empregado é de R$ %.2f" % salario_empregado2
else:
	print "O valor da contribuição do INSS a ser pago pelo empregado é de R$ %.2f" % salario_empregado3

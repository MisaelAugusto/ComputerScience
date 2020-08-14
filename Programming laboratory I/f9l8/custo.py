# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Custo Empregado

salario_base = float(raw_input())
dias_trabalhados = int(raw_input())
transporte_diario = float(raw_input())
custo_transporte = dias_trabalhados * transporte_diario

if salario_base <= 1317.07:
	INSS = 0.08 * salario_base
elif 1317.08 <= salario_base <= 2195.12:
	INSS = 0.09 * salario_base
else:
	INSS = 0.11 * salario_base

if custo_transporte > (0.06 * salario_base):
	transporte_empregado = 0.06 * salario_base
	transporte_empregador = custo_transporte - (0.06 * salario_base)
else:
	transporte_empregador = 0
	transporte_empregado = 0

custo_empregador = (salario_base * 0.20) + transporte_empregador + salario_base
custo_empregado = INSS + transporte_empregado

print "O salário base é R$ %.2f" % salario_base
print "O custo mensal para o empregador é de R$ %.2f" % custo_empregador
print "O salário líquido que o trabalhador irá receber no mês é R$ %.2f" % (salario_base - custo_empregado)





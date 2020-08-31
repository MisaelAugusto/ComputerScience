# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Análise de Variação do Salário Mínimo

ano_inicial = int(raw_input())
ano_final = int(raw_input()) + 1

acima = 0
abaixo = 0
salarios_acima = []
salarios_abaixo = []
total1 = 0
total2 = 0
for i in range(ano_final - ano_inicial):
	salario = float(raw_input())
	if salario > 100:
		acima += 1
		salarios_acima.append(salario)
		total1 += salario
	if salario < 100:
		abaixo += 1
		salarios_abaixo.append(salario)
		total2 += salario

porcentagem_abaixo = abaixo * 100 / (ano_final - ano_inicial)
print "%d ano(s) abaixo (%d%% dos anos)" % (abaixo, porcentagem_abaixo)
if total2 != 0:
	print "média dos anos abaixo: U$ %.2f" % (total2 / len(salarios_abaixo))

porcentagem_acima = 100 - porcentagem_abaixo
print "%d ano(s) acima (%d%% dos anos)"	% (acima, porcentagem_acima)
if total1 != 0:
	print "média dos anos acima: U$ %.2f" % (total1 / len(salarios_acima))


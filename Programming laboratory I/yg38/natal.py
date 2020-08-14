# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Gratificação Natalina

codigo = int(raw_input())

if codigo == 1:
	print "Deverá receber em dezembro R$ 25000.00."
elif codigo == 2:
	print "Deverá receber em dezembro R$ 15000.00."
elif codigo == 3:
	faltas = int(raw_input())
	if faltas == 0:
		G = 500
	else:
		G = (235 - faltas) * 2
	salario_total = 8000 + G
	print "Valor da gratificação R$ %.2f." % G
	print "Deverá receber em dezembro R$ %.2f." % salario_total
elif codigo == 4:
	faltas = int(raw_input())
	if faltas == 0:
		G = 300
	else:
		G = (235 - faltas) * 1
	salario_total = 5000 + G
	print "Valor da gratificação R$ %.2f." % G
	print "Deverá receber em dezembro R$ %.2f." % salario_total
else:
	faltas = int(raw_input())
	if faltas == 0:
		G = 200
	else:
		G = (235 - faltas) * 0.7
	salario_total = 2800 + G
	print "Valor da gratificação R$ %.2f." % G
	print "Deverá receber em dezembro R$ %.2f." % salario_total


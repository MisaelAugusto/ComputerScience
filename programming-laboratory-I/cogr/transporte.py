# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Transporte Modificado

pessoas = int(raw_input())
valor_disponivel = float(raw_input())

passagem_tav = 100 * pessoas
passagem_onibus = 22 * pessoas
if pessoas <= 4:
	passagem_taxi = 200
else:
	if pessoas % 4 > 0:
		passagem_taxi = 200 + 200 * (pessoas/4)
	else:
		passagem_taxi = 200 * (pessoas/4)
if valor_disponivel < passagem_onibus:
	print "Não é possível realizar a viagem."
else:
	if valor_disponivel >= passagem_tav:
		print "TAV. R$ %.2f" %passagem_tav
	elif valor_disponivel >= passagem_taxi:
		print "Táxi. R$ %.2f" %passagem_taxi
	elif valor_disponivel >= passagem_onibus:
		print "Ônibus. R$ %.2f" %passagem_onibus
	



# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Pedágio

tipo_veiculo = raw_input()

if tipo_veiculo == "Ônibus":
	eixos = int(raw_input())
	preco = 11.40 * eixos
	print "Valor a pagar: R$ %.2f." % preco
elif tipo_veiculo == "Automóvel utilitário":
	preco = 11.40
	print "Valor a pagar: R$ %.2f." % preco
elif tipo_veiculo == "Caminhão":
	eixos = int(raw_input())
	preco = 9.60 * eixos 
	print "Valor a pagar: R$ %.2f." % preco
elif tipo_veiculo == "Motocicleta":
	preco = 5.70
	print "Valor a pagar: R$ %.2f." % preco
else:
	print "Veículo não cadastrado."

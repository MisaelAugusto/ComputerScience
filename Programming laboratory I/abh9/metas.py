# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Sistema de Metas Mensal

meta = float(raw_input())
total = 0
vendas = []
for i in range(6):
	vendas_funcionario = float(raw_input())
	total += vendas_funcionario
	vendas.append(vendas_funcionario)
for n in vendas:
	if n >= (meta / 6):
		bonus = True
	else:
		bonus = False
		break
if bonus:		
	print "Total de vendas: R$ %.2f (meta atingida)" % total
	print "----"
	print "Bonificação:"
	for i in range(1, 7):
		print "Funcionário %d: R$ %.2f" % (i, vendas[i - 1] / 100.0)
else:
	print "Total de vendas: R$ %.2f (meta não foi atingida)" % total
	print "----"

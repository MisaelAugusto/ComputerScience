# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Operações Bancárias

nome_e_saldo = raw_input().split()
saldo_final = float(nome_e_saldo[1])

while True:
	entrada = raw_input().split()
	if entrada[0] == "3":
		break
	elif entrada[0] == "2":
		saldo_final += float(entrada[1])
	else:
		saldo_final -= float(entrada[1])

print "Saldo de R$ %.2f na conta de %s" % (saldo_final, nome_e_saldo[0])

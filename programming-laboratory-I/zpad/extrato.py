# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Verifica Operações Extrato

N = int(raw_input())
saldo_atual = float(raw_input())

saques = 0
while True:
	operacao = raw_input().split()
	if operacao[0] == "depósito":
		if float(operacao[1]) > 1000.00:
			print "Operação inválida: depósito %.2f." % (float(operacao[1]))
			break
		else:
			saldo_atual += float(operacao[1])
	elif operacao[0] == "saque":
		saques += 1
		if saques <= N:
			if saldo_atual - float(operacao[1]) < 0:
				print "Operação inválida: saque %.2f." % (float(operacao[1]))
				break
			else:
				saldo_atual -= float(operacao[1])
		else:
			print "Operação inválida: saque %.2f." % (float(operacao[1]))
			break
			
print "Seu saldo é R$ %.2f." % saldo_atual

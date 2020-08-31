# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Fundo de Investimento

saldo = 0
n = 0
while True:
	valor = float(raw_input())
	saldo += valor
	n += 1
	media = saldo / n
	if valor < media:
		saldo -= valor
		media = saldo / (n - 1)
		break
	
print "Saldo total do FIS: R$%.2f." % saldo
print "Média das contribuições: R$%.2f." % media

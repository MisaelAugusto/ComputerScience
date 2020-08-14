# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Roleta

numero_aposta = int(raw_input())
cor_aposta = raw_input()

numero_sorteado = int(raw_input())
cor_sorteada = raw_input()

condicao1 = numero_aposta == numero_sorteado
condicao2 = cor_aposta == cor_sorteada

if condicao1:
	if condicao2:
		print 150
	else:
		print 100
else:
	if condicao2:
		if numero_sorteado > numero_aposta:
			print 80
		else:
			print 100
	else:
		print 0
		


	
	

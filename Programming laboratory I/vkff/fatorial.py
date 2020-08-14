# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Fatorial

numero = int(raw_input())

fatorial = 1
for i in range(numero):
	fatorial *= numero 
	numero -= 1
	
print fatorial

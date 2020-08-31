# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Depois do 13 Nada

num1 = int(raw_input())
num2 = int(raw_input())
num3 = int(raw_input())

if num1 == 13:
	print "0"
elif num2 == 13:
	print num1
elif num3 == 13:
	if num1 + num2 == 13:
		print "0"
	else:
		print num1 + num2
else:
	print num1 + num2 + num3
	

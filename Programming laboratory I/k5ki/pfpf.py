# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Plif Plof

num1 = int(raw_input())
num2 = int(raw_input())
num3 = int(raw_input())

total = num1 + num2 + num3

if total % 3 == 0:
	if total % 5 == 0:
		print "plifplof"
	else:
		print "plif"
else:
	if total % 5 == 0:
		print "plof"
	else:
		print total

# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Validação de Triângulos

a = int(raw_input())
b = int(raw_input())
c = int(raw_input())

condicao1 = abs(b - c) < a < (b + c)

if condicao1:
	perimetro = a + b + c
	print "triangulo valido. %i" % perimetro
else:
	print "triangulo invalido."

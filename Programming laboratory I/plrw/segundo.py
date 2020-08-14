# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Segundo Maior e Segundo Menor

num1 = int(raw_input())
num2 = int(raw_input())
num3 = int(raw_input())
num4 = int(raw_input())

print "Considerando os números %d, %d, %d e %d" % (num1, num2, num3, num4)

if (num1 >= num2 >= num3 >= num4) or (num4 >= num2 >= num3 >= num1):
	print "O segundo menor número é %d\nO segundo maior número é %d" % (num3, num2)
elif (num1 >= num3 >= num2 >= num4) or (num4 >= num3 >= num2 >= num1):
	print "O segundo menor número é %d\nO segundo maior número é %d" % (num2, num3)
elif (num1 >= num3 >= num4 >= num2) or (num2 >= num3 >= num4 >= num1):
	print "O segundo menor número é %d\nO segundo maior número é %d" % (num4, num3)
elif (num1 >= num4 >= num3 >= num2) or (num2 >= num4 >= num3 >= num1):
	print "O segundo menor número é %d\nO segundo maior número é %d" % (num3, num4)
elif (num1 >= num2 >= num4 >= num3) or (num3 >= num2 >= num4 >= num1):
	print "O segundo menor número é %d\nO segundo maior número é %d" % (num4, num2)
elif (num1 >= num4 >= num2 >= num3) or (num3 >= num4 >= num2 >= num1):
	print "O segundo menor número é %d\nO segundo maior número é %d" % (num2, num4)
elif (num2 >= num1 >= num4 >= num3) or (num3 >= num1 >= num4 >= num2):
	print "O segundo menor número é %d\nO segundo maior número é %d" % (num4, num1)
elif (num2 >= num4 >= num1 >= num3) or (num3 >= num4 >= num1 >= num2):
	print "O segundo menor número é %d\nO segundo maior número é %d" % (num1, num4)
elif (num2 >= num1 >= num3 >= num4) or (num4 >= num1 >= num3 >= num2):
	print "O segundo menor número é %d\nO segundo maior número é %d" % (num3, num1)
elif (num2 >= num3 >= num1 >= num4) or (num4 >= num3 >= num1 >= num2):
	print "O segundo menor número é %d\nO segundo maior número é %d" % (num1, num3)
elif (num3 >= num1 >= num2 >= num4) or (num4 >= num1 >= num2 >= num3):
	print "O segundo menor número é %d\nO segundo maior número é %d" % (num2, num1)
elif (num3 >= num2 >= num1 >= num4) or (num4 >= num2 >= num1 >= num3):
	print "O segundo menor número é %d\nO segundo maior número é %d" % (num1, num2)


# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Sequencia de DNA

sequencia1 = raw_input()
sequencia2 = raw_input()

sim = 0
for i in range(len(sequencia1)):
	if sequencia1[i] == sequencia2[i]:
		sim += 1

if sim > (len(sequencia1) / 2.0):
	print "sim"
else:
	print "nao"		

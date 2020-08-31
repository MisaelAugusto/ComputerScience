# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Maior Torcida

torcida1 = 0
torcida2 = 0

for i in range(10):
	torcida = int(raw_input())
	if i <= 4:
		torcida1 += torcida
	else:
		torcida2 += torcida
		
if torcida1 > torcida2:
	print "O primeiro time leva mais torcedores ao estádio."
elif torcida2 > torcida1:
	print "O segundo time leva mais torcedores ao estádio."
else:
	print "Empate."

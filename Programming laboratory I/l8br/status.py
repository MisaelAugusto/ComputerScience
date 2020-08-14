# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Status Unidade

minitestes = int(raw_input())

if minitestes > 1:
	nota1 = float(raw_input())
	nota2 = float(raw_input())
	if minitestes > 2:
		nota3 = float(raw_input())
		if minitestes > 3:
			nota4 = float(raw_input())
			media = ((nota1 + nota2 + nota3 + nota4) / 4) - 0.5
		else:
			media = ((nota1 + nota2 + nota3) / 3) - 0.5
	else:
		media = (nota1 + nota2) / 2
else:
	media = float(raw_input())

print media

if media >= 6:
	print "Aluno aprovado na unidade"
else:
	print "Aluno ainda não aprovado na unidade"
		

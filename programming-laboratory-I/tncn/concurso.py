# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Concurso

nota1 = float(raw_input())
nota2 = float(raw_input())
nota3 = float(raw_input())
idade1 = int(raw_input())

nota4 = float(raw_input())
nota5 = float(raw_input())
nota6 = float(raw_input())
idade2 = int(raw_input())

media1 = nota1 * 0.3 + nota2 * 0.4 + nota3 * 0.3
media2 = nota4 * 0.3 + nota5 * 0.4 + nota6 * 0.3

if media1 > media2:
	print "O primeiro candidato foi aprovado com média %.1f." % media1
elif media1 < media2:
	print "O segundo candidato foi aprovado com média %.1f." % media2
else:
	if idade1 > idade2:
		print "O primeiro candidato foi aprovado com média %.1f." % media1
	elif idade1 < idade2:
		print "O segundo candidato foi aprovado com média %.1f." % media2
	else:
		print "Empate."

# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Status de uma Disciplina

nota1 = float(raw_input())
nota2 = float(raw_input())
nota3 = float(raw_input())
faltas = int(raw_input())

media = (nota1 + nota2 + nota3) / 3
if faltas > 7:
	print "reprovado por faltas"
else:
	if 0 < media < 4:
		print "reprovado por nota"
	elif 4 <= media < 7:
		print "prova final"
	else:
		print "aprovado por media"
		

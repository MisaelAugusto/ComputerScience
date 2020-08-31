# coding: utf-8
# ALuno: Misael Augusto
# Matrícula: 117112505
# Problema: Seleção Projeto

cre = float(raw_input())
experiencia = float(raw_input())
nota = float(raw_input())

if cre < 7:
	if experiencia < 6:
		print "Candidato eliminado. CRE e experiência abaixo do limite."
	else:
		print "Candidato eliminado. CRE abaixo do limite."
else:
	if experiencia >= 6:
		if nota <= 3:
			print "Candidato classificado."
		else:
			print "Candidato aprovado."
	else:
		print "Candidato eliminado. Experiência abaixo do limite."

	

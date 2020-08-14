# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Classifica Corredor


kilometros = float(raw_input())
tempo = float(raw_input())

velocidade = kilometros / tempo

if velocidade < 10:
	print "Velocidade: %.1fkm/h. Corredor amador." % velocidade
elif 10 <= velocidade <= 15:
	print "Velocidade: %.1fkm/h. Corredor aspirante." % velocidade
else:
	print "Velocidade: %.1fkm/h. Corredor profissional." % velocidade

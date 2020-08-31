# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Clássico dos Maiorais

gols_campinense = int(raw_input())
gols_treze = int(raw_input())

if gols_campinense > gols_treze:
	print "Campinense"
elif gols_campinense < gols_treze:
	print "Treze"
else:
	print "Empate"

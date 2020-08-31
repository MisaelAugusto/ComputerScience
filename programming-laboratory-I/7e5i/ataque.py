# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Ataque Mais Positivo de um Campeonato

N = int(raw_input())

times = []
gols = []
total_gols = 0
for i in range(N):
	nome_time = raw_input()
	numero_de_gols = float(raw_input())
	times.append(nome_time)
	gols.append(numero_de_gols)
	total_gols += numero_de_gols
media = total_gols / N

melhor_ataque = 0
for i in gols:
	if i > melhor_ataque:
		melhor_ataque = i
		
melhores_times = []		
for i in range(N):
	if gols[i] == melhor_ataque:
		melhores_times.append(times[i])
	
print "Time(s) com melhor ataque (%d gol(s)):" % (melhor_ataque)
for i in melhores_times:
	print i
print ""
print "Média de gols marcados: %.1f" % media

			

# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Campanha

gols_marcados = 0
gols_sofridos = 0
pontos_fora = 0
pontos_casa = 0
vitorias = 0
derrotas = 0
empates = 0
for i in range(10):
	partida = raw_input()
	if partida[5] == "c":
		gols_marcados += int(partida[0])
		gols_sofridos += int(partida[2])
		if int(partida[0]) > int(partida[2]):
			vitorias += 1
			pontos_casa += 3
		elif int(partida[0]) == int(partida[2]):
			empates += 1
			pontos_casa += 1
		else:
			derrotas += 1
		
	else:
		gols_marcados += int(partida[2])
		gols_sofridos += int(partida[0])
		if int(partida[2]) > int(partida[0]):
			vitorias += 1
			pontos_fora += 3
		elif int(partida[2]) == int(partida[0]):
			empates += 1
			pontos_fora += 1
		else:
			derrotas += 1

pontos = (vitorias * 3) + empates
saldo = gols_marcados - gols_sofridos 

print "%dv, %de, %dd" %(vitorias, empates, derrotas)
print "pontos: %d" % pontos
print "saldo: %d (%d pro, %d contra)" % (saldo, gols_marcados, gols_sofridos)
print "pontos em casa: %d" % pontos_casa
print "pontos fora: %d" % pontos_fora

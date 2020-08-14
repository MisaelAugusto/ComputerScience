# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Iniciadas por consoantes

N = int(raw_input())

consoantes = ["b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"]
iniciadas_consoantes = 0
for i in range(N):
	palavra = raw_input()
	if palavra[0] in consoantes:
		iniciadas_consoantes += 1
		
porcentagem = iniciadas_consoantes * 100.0 / N
print "total de palavras: %d" % N
print "iniciadas por consoantes: %d (%.2f%%)" % (iniciadas_consoantes, porcentagem)

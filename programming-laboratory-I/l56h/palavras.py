# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Palavras com Letras Dobradas

N = int(raw_input())

com_dobradas = []
sem_dobradas = []
for i in range(N):
	ciclos = 0
	palavra = raw_input()
	for i in range(len(palavra) - 1):
		if palavra[i] == palavra[i + 1]:
			com_dobradas.append(palavra)
			break
		else:
			ciclos += 1
	if ciclos == (len(palavra) - 1):
		sem_dobradas.append(palavra)
		
print "%d palavra(s) com letras dobradas:" % (len(com_dobradas))
for palavra in com_dobradas:
	print palavra
print "---"
print "%d palavra(s) sem letras dobradas:" % (len(sem_dobradas))
for palavra in sem_dobradas:
	print palavra


# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Imprime Ranking (CNumulativo)
""" resolver quando todos são iguais !!!"""
n = int(raw_input())

nomes_times = []
pontos_times = []
for i in range(n):
	nome = raw_input()
	pontos = int(raw_input())
	nomes_times.append(nome)
	pontos_times.append(pontos)

ciclos = 0
condicao = True
for i in range(n):
	if pontos_times[i] == pontos_times[i - 1]:
		ciclos += 1
		if ciclos == n:
			condicao = False
			for i in range(n):
				print "%d. %s (%d)" % (1, nomes_times[i], pontos_times[i])
			break
if condicao:
	print "%d. %s (%d)" % (1, nomes_times[0], pontos_times[0])
	for i in range(1, n):
		if pontos_times[i] == pontos_times[i - 1]:
			print "%d. %s (%d)" % (i, nomes_times[i], pontos_times[i])
		else:	
			print "%d. %s (%d)" % (i + 1, nomes_times[i], pontos_times[i])
	

# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Premiação Cliente

contadores = [0, 0, 0, 0]
inicia = True
while True:
	entrada = raw_input().split()
	if entrada[0] == "fim":
		break
	if entrada[0] == "joao":
		contadores[0] += 1
		contadores[1] += float(entrada[1])
		if contadores[0] >= 3:
			print "joao foi o vencedor. Comprou mais de duas vezes no período."
			inicia = False
			break
		if contadores[1] > 2000:
			print "joao foi o vencedor. Comprou mais R$ 2000.00 no período."
			inicia = False
			break
	else:
		contadores[2] += 1
		contadores[3] += float(entrada[1])
		if contadores[2] >= 3:
			print "julio foi o vencedor. Comprou mais de duas vezes no período."
			inicia = False
			break
		if contadores[3] > 2000:
			print "julio foi o vencedor. Comprou mais R$ 2000.00 no período."
			inicia = False
			break
		
if inicia:
	print "Não houve vencedor."

# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Imprime Sequencias de Números Inteiros

numero = int(raw_input())
sequencias = []
maior = 0

while True:
	sequencia = raw_input()
	if sequencia == "fim":
		break
	sequencia = sequencia.split()
	sequencias.append(sequencia)


ciclo = 1
for s in sequencias:
	maior = 0
	for i in range(len(s)):
		if int(s[i]) > numero:
			maior += 1	
	if len(s) % 2 == 0:
		if maior > (len(s) / 2):
			sequencia = " ".join(s)
			print "sequencia %d: %s" %(ciclo, sequencia)
	else:
		if maior >= ((len(s) / 2) + 1):
			sequencia = " ".join(s)
			print "sequencia %d: %s" %(ciclo, sequencia)
	ciclo += 1



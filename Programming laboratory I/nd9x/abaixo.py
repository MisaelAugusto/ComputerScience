# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Abaixo da média

total = 0
valores = []
while True:
	 entrada = raw_input()
	 if entrada == "fim":
		 break
	 total += float(entrada)
	 valores.append(int(entrada))

media = total / len(valores)

print "%.2f" % media

for i in range(len(valores)):
	if valores[i] < media:
		print "%d %d" % (i + 1, valores[i])

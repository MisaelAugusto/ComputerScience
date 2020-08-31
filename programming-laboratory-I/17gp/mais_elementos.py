# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Conjunto com mais elementos

tamanho = 0
tamanhos = []
while True:
	numero = raw_input()
	if numero == "fim":
		break
	else:
		if int(numero) >= 0:
			tamanho += 1
		else:
			tamanhos.append(tamanho)
			tamanho = 0

if len(tamanhos) > 0:
	maior = tamanhos[0]
	conjunto = 0
	for i in range(1, len(tamanhos)):
		if tamanhos[i] > maior:
			maior = tamanhos[i]
			conjunto = i
	print "Conjunto %d - %d elemento(s)" % (conjunto + 1, maior)
	

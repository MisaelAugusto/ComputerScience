# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Pesquisa Hotéis

valores = []
tamanhos = []
confortos = []
hoteis = []
while True:
	entrada = raw_input().split(",")
	if entrada[0] == "---":
		break
	valores.append(entrada[0])
	tamanhos.append(entrada[1])
	confortos.append(entrada[2])
	hoteis.append(entrada[3])


while True:
	criterio = raw_input()
	if criterio == "fim":
		break	
	hotel = hoteis[0]
	if criterio == "valor":	
		menor_valor = float(valores[0])
		for i in range(1, len(valores)):
			if float(valores[i]) < menor_valor:
				menor_valor = float(valores[i])
				hotel = hoteis[i]
	elif criterio == "tamanho":			
		maior_tamanho = float(tamanhos[0])
		for i in range(1, len(tamanhos)):	
			if int(tamanhos[i]) > maior_tamanho:
				maior_tamanho = int(tamanhos[i])
				hotel = hoteis[i]
	else:
		maior_conforto = int(confortos[0])
		for i in range(1, len(confortos)):
			if int(confortos[i]) > maior_conforto:
				maior_conforto = int(confortos[i])
				hotel = hoteis[i]
	print hotel

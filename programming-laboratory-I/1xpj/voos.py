# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Pesquisa Voos

N = int(raw_input())

valores = []
conexoes = []
tempos = []
cias = []
for i in range(N):
	entrada = raw_input().split(",")
	valores.append(float(entrada[0]))
	conexoes.append(int(entrada[1]))
	tempos.append(int(entrada[2]))
	cias.append(entrada[3])

while True:
	criterio = raw_input()
	if criterio == "fim":
		break
	cia = cias[0]
	if criterio == "valor":
		menor_valor = valores[0]
		for i in range(1, len(valores)):
			if valores[i] < menor_valor:
				menor_valor = valores[i]
				cia = cias[i]
	elif criterio == "tempo":
		menor_tempo = tempos[0]
		for i in range(1, len(tempos)):
			if tempos[i] < menor_tempo:
				menor_tempo = tempos[i]
				cia = cias[i]
	else:
		menos_conexoes = conexoes[0]
		for i in range(1, len(conexoes)):
			if conexoes[i] < menos_conexoes:
				menos_conexoes = conexoes[i]
				cia = cias[i]
	print cia

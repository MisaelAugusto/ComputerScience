# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Limite de gastos

media_secretaria = float(raw_input())

medias_acima = []
while True:
	total = 0
	entrada = raw_input().split()
	if entrada[0] == "fim":
		break
	else:
		for gasto in entrada:
			total += float(gasto)
		media = total / len(entrada)
		if media <= (media_secretaria / 2):
			break
		if media > media_secretaria:
			medias_acima.append(entrada)
		else:
			continue
for m in medias_acima:
	m = " ".join(m)
	print m

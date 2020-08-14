# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Utilizando o Teorema de Herão para Calcular a Área de Triângulos

import math

N = int(raw_input())

areas = []
for i in range(N):
	medidas = raw_input().split()
	a = float(medidas[0])
	b = float(medidas[1])
	c = float(medidas[2])
	s = (a + b + c) / 2
	area = math.sqrt(s * (s - a) * (s - b) * (s - c))
	areas.append(area)
	
maiores = 0
total = 0
for i in range(N):
	if areas[i] > 100:
		maiores += 1
		total += areas[i]
	print "Área %d: %.2f" % ((i + 1), areas[i])
	
if maiores > 0:
	media = total / maiores
	print "Número maiores: %d, área média: %.2f" % (maiores, media)

# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Classificação de Elementos Utilizando a Média dos Extremos

N = int(raw_input())

numeros = []
for i in range(N):
	numero = int(raw_input())
	numeros.append(numero)
	
maior = numeros[0]
menor = numeros[0]
for n in numeros:
	if n >= maior:
		maior = n
	if n <= menor:
		menor = n

media = (maior + menor) / 2.0

print "Menor número: %d" % menor
print "Maior número: %d" % maior
print "Média dos extremos: %.2f" % (media)

abaixo = 0
acima = 0
for n in numeros:
	if n > media:
		acima += 1
	if n < media:
		abaixo += 1
		
print "%d número(s) abaixo da média" % abaixo
print "%d número(s) acima da média" % acima

# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Calculadora de Médias

def MA(lista):
	total = 0
	for numero in lista:
		total += float(numero)
	media = total / len(lista)
	
	return "Média Aritmética: %.4f" % media

def MG(lista):
	total = 1
	for numero in lista:
		total *= float(numero)
	media = total ** (1.0 / len(lista))
	
	return "Média Geométrica: %.4f" % media

def MH(lista):
	total = 0.0
	for numero in lista:
		total += 1 / float(numero)
	media = len(lista) / total
	
	return "Média Harmônica: %.4f" % media
	
while True:
	operacoes = raw_input().split()
	if operacoes[0] == "Q":
		break
	else:
		numeros = raw_input().split()
		for operacao in operacoes:
			if operacao == "MA":
				print MA(numeros)
			elif operacao == "MG":
				print MG(numeros)
			else:
				print MH(numeros)
		print "----"

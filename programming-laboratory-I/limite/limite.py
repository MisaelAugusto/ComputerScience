# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Média Atinge Limite

total = 0
numeros = []
while True:
	numero = raw_input()
	if numero == "-":
		break
	numeros.append(numero)

limite = float(raw_input())

n = 1
total = 0
for i in range(len(numeros)):
	total += float(numeros[i])
	media =  total / n
	if media > limite:
		print "media = %.1f" % media
		print "num = %d" % n
		break
	else:
		if i == len(numeros) - 1:
			print "limite não alcançado"
			break
	n += 1

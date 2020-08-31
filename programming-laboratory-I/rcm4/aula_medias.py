# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Aula de médias

soma = 0
num_lidos = 0
numeros = []
while soma < 100:
	numero = float(raw_input())
	num_lidos += 1
	soma += numero
	numeros.append(numero)
	
media = soma / num_lidos

print "Quantidade de números lidos: %d" % num_lidos
print "Soma dos números lidos: %.2f" % soma
print "Média = %.2f" % media
print ""
print "Abaixo da média"
for i in range(len(numeros)):
	if numeros[i] < media:
		print "%.2f (%do)" % (numeros[i], i + 1)
print ""
print "Acima da média"
for i in range(len(numeros)):
	if numeros[i] > media:
		print "%.2f (%do)" % (numeros[i], i + 1)

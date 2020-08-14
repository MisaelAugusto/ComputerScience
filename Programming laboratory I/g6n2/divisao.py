# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Divisão por Subtrações

numeros = raw_input().split()
P = int(numeros[0])
Q = int(numeros[1])

quociente = 0
while True:
	if P >= Q:
		print "%d - %d = %d" % (P, Q, P - Q)
		quociente += 1
	else:
		print "%d - %d < 0" % (P, Q)
		resto = P
		break
	P = P - Q		

print "==="
print "quociente = %d" % quociente
print "resto = %d" % resto

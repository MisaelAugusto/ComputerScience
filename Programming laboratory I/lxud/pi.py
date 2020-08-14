# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Pi por Aproximações

e = float(raw_input())
pi = 4.0

print "%.6f" % pi

n = -3
while True:
	pi2 = pi + 4 * (1.0 / n)
	print "%.6f" % pi2
	if abs(pi - pi2) < e:
		break
	if n < 0:
		n = n * (-1) + 2
	else:
		n = (n + 2) * (-1)
	pi = pi2

# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Tiro ao alvo

total = 0
disparos = 0
while True:
	posicao = raw_input().split(",")
	dist = (float(posicao[0]) ** 2 + float(posicao[1]) ** 2) ** (0.5)
	if dist > 200:
		break
	else:
		disparos += 1
		total += dist
		print "%.2f" % dist
	
media = total / disparos
	
print "--"
print "num disparos: %d" % disparos
print "distancia media: %.2f" % media
	

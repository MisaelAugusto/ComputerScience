# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Tiro ao Alvo 2

tiros = 0
distancia_total = 0
distancias = []
while True:
	x = float(raw_input())
	y = float(raw_input())
	distancia = (x ** 2 + y ** 2) ** (0.5)
	if distancia > 200:
		break
	tiros += 1
	distancias.append(distancia)
	distancia_total += distancia

distancia_media = distancia_total / len(distancias)
melhor_tiro = distancias[0]
print "%.2f cm (melhor tiro)" % melhor_tiro
for i in range(1, len(distancias)):
	if melhor_tiro > distancias[i]:
		melhor_tiro = distancias[i]
		print "%.2f cm (melhor tiro)" % melhor_tiro
	else:
		print "%.2f cm" % distancias[i]
		
print "--"
print "num tiros: %d" % tiros
print "melhor tiro: %.2f cm" % melhor_tiro
print "distancia media: %.2f cm" % distancia_media

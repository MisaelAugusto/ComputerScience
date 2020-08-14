# coding: utf-8
# ALuno: Misael Augusto
# Matrícula: 117110525
# Problema: Mastery Learning

print "Mastery Learning"
print "Cálculo da nota na unidade"
print ""

notas = []
penalizacao = 0.0
medias = []
while True:
	notas.append(float(raw_input("Nota? ")))
	if len(notas) < 2:
		continue
	else:
		menor = 0
		penalizacao += ((len(notas) - 2) * 0.5)
		while len(notas) > 2:
			menor = 100
			for i in range(len(notas)):
				if notas[i] < menor:
					menor = notas[i]
					indice = i
			notas.pop(indice)
		media = (notas[0] + notas[1]) / 2
		medias.append(media)
		if media < 6:
			print "Média: %.1f (cursando)" % media
			print "Penalização: %.1f" % penalizacao
			print ""
		else:
			print "Média: %.1f (aprovado)" % media
			print "Penalização: %.1f" % penalizacao
			print ""
			break		

total_medias = 0
for media in medias:
	total_medias += media

print "==="
if notas[0] >= notas[1]:
	print "Notas válidas: %.1f e %.1f" % (notas[0], notas[1])
else:
	print "Notas válidas: %.1f e %.1f" % (notas[1], notas[0])

print "Média parcial na unidade: %.1f" % media
print "Penalizações: %.1f" % penalizacao
print "Média final na unidade: %.1f" % (total_medias / len(medias))

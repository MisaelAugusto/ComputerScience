# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Aprovados e Reprovados

N = int(raw_input())

aprovados = 0
reprovados = 0
aprovados_media = 0
reprovados_media = 0
for i in range(N):
	media = float(raw_input())
	if media >= 7.0:
		aprovados += 1
		aprovados_media += media 
	else:
		reprovados += 1
		reprovados_media += media
print "Reprovados: %d" % reprovados

if reprovados > 0:	
	print "Média: %.1f" % (reprovados_media / reprovados)

print ""
print "Aprovados: %d" % aprovados

if aprovados > 0:
	print "Média: %.1f" % (aprovados_media / aprovados)

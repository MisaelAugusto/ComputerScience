# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: DNA

dna1 = raw_input()
dna2 = raw_input()
dna3 = raw_input()

tamanho1 = len(dna1)
tamanho2 = len(dna2)
tamanho3 = len(dna3)

if tamanho2 < tamanho1 and tamanho2 < tamanho3:
	print "%s %i" % (dna2, tamanho2)
elif tamanho3 < tamanho2 and tamanho3 < tamanho1:
	print "%s %i" % (dna3, tamanho3)
else:
	print "%s %i" % (dna1, tamanho1)

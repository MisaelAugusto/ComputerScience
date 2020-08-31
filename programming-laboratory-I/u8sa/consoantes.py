# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Mais consoantes

vogais = ["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"]
palavras = 0
while True:
	palavra = raw_input()
	palavras += 1
	num_vogais = 0
	for letra in palavra:
		if letra in vogais:
			num_vogais += 1
	if num_vogais < (len(palavra) - num_vogais):
		break

print palavras

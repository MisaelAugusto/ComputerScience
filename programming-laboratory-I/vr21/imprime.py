# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Imprime primeira Vogal

palavra = raw_input()
vogais = ["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"]
for letra in palavra:
	if letra in vogais:
		consoante = False
		print letra
		break
	else:
		consoante = True
if consoante:
	print "-"	

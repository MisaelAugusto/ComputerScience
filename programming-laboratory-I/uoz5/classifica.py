# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Classifica Letra como Vogal ou Consoante

palavra = raw_input()
vogais = ["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"]

for letra in palavra:
	if letra in vogais:
		print "<%s> sim" % letra
	else:
		print "<%s> nao" % letra

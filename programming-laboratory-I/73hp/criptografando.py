# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Criptografando uma Senha

palavra = list(raw_input())

trocas = 0
for i in range(1, len(palavra)):
	if palavra[i] == "a" or palavra[i] == "A":
		palavra[i] = "4"
		trocas += 1
	elif palavra[i] == "e" or palavra[i] == "E":
		palavra[i] = "3"
		trocas += 1
	elif palavra[i] == "i" or palavra[i] == "I":
		palavra[i] = "1"
		trocas += 1
	elif palavra[i] == "o" or palavra[i] == "O":
		palavra[i] = "0"
		trocas += 1

palavra = "".join(palavra)
print "%s (%d troca(s))" % (palavra, trocas)

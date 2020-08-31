# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Espaço por vírgula

frase = raw_input()
i = int(raw_input())
j = int(raw_input())

saida = frase[i]
for n in range(i + 1, j):
	if frase[n] == " ":
		x = ","
		saida += " " + x
	else:
		x = ""
		saida += " " + x + frase[n]

print saida

# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Mais ocorrências de um Caractere

palavras = []
while True:
	palavra = raw_input()
	if palavra == "fim":
		break
	palavras.append(palavra)

c = raw_input()
N = int(raw_input())	

palavras_especiais = []
for p in palavras:
	frequencia = 0
	for letra in p:
		if letra == c:
			frequencia += 1
	if frequencia > N:
		palavras_especiais.append(p)
if len(palavras_especiais) > 0:
	for palavra in palavras_especiais:
		print palavra
else:
	print "Nenhuma palavra encontrada."

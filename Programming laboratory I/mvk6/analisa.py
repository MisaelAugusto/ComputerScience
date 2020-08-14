# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Analisa Chave

chave = raw_input().lower()
vogais = ["a", "e", "i", "o", "u"]

inicia = True
if len(chave) > 2:	
	vogal = 0
	for i in range(len(chave)):
		if (i < len(chave) - 2) and (chave[i] == chave[i + 1] == chave[i + 2]):
			print "Chave insegura. 3 caracteres consecutivos iguais."
			inicia = False
			break
		
		if chave[i] in vogais:
			vogal += 1
		
		if vogal > 5:
			print "Chave insegura. 6 vogais."
			inicia = False
			break

if inicia:
	print "Chave segura!"			

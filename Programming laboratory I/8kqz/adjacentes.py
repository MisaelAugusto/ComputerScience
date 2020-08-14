# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Tem vogais adjacentes

def tem_vogais_adjacentes(palavra):
	vogais = ["a", "e", "i", "o", "u"]
	inicia = True
	n = 0
	for i in range(len(palavra) - 1):
		for vogal in vogais:
			if palavra[i].lower() == vogal:
				n += 1
			if palavra[i + 1].lower() == vogal:
				n += 1
		
		if n == 2:
			mensagem = "sim"
			inicia = False
			break
		else:
			n = 0
	
	if inicia:
		mensagem = "nao"

			
	return mensagem
	
palavra = raw_input()

print tem_vogais_adjacentes(palavra)

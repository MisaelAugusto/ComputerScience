# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Hospital de Trauma

def cadastra(fila, nome, prioridade):
	nomes.append(nome)
	for i in range(len(prioridade)):
		for i in range(len(prioridade) - 1):
			if prioridade[i] < prioridade[i + 1]:
				prioridade[i], prioridade[i + 1] = prioridade[i + 1], prioridade[i]
				fila[i], fila[i + 1] = fila[i + 1], fila[i]
	
	return fila
	
def resumo():
	for nome in nomes:
		print nome
	print "---"
	for i in range(0, len(prioridades) - 1, 2):
		print "%s: %d" % (prioridades[i], prioridades[i + 1])
	print "---"
		
prioridades = ["vermelho", 0, "laranja", 0, "amarelo", 0, "verde", 0, "azul", 0]
prioridade = []
nomes = []
while True:
	dados = raw_input().split()
	if dados[0] == "fim":
		resumo()
		break
	else:
		if dados[1] == "vermelho":
			prioridades[1] += 1
			p = 5
		elif dados[1] == "laranja":
			prioridades[3] += 1
			p = 4
		elif dados[1] == "amarelo":
			prioridades[5] += 1
			p = 3
		elif dados[1] == "verde":
			prioridades[7] += 1
			p = 2
		else:
			prioridades[9] += 1
			p = 1
		
		prioridade.append(p)
		cadastra(nomes, dados[0], prioridade)



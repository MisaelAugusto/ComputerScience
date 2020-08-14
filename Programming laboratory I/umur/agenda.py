# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Agenda Telefônica

def ordena(nomes, telefones):
	inicia = True
	while inicia:
		inicia = False
		for j in range(len(nomes) - 1):
			if nomes[j] > nomes[j + 1]:
				nomes[j], nomes[j + 1] = nomes[j + 1], nomes[j]
				telefones[j], telefones[j + 1] = telefones[j + 1], telefones[j]
				inicia = True
				
nomes = []
telefones = []
while True:
	operacao = raw_input()
	if operacao == "finalizar":
		break
	else:
		if operacao == "inserir":	
			quantidade = int(raw_input())
			for i in range(quantidade):
				nomes.append(raw_input())
				telefones.append(raw_input())
			ordena(nomes, telefones)
			
		elif operacao == "buscar":
			nome = raw_input()
			aux = 0
			for i in range(len(nomes)):
				if nomes[i] == nome:
					print "Nome: %s" % nomes[i]
					print "Fone: %s" % telefones[i]
				else:
					aux += 1
					
			if aux == len(nomes):
				print "Nome inexistente"
			
			print "----------"
			
		else:
			for j in range(len(nomes)):
				print "Nome: %s" % nomes[j]
				print "Fone: %s" % telefones[j]
				print "----------"

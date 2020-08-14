# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Questões para P1

nomes = []
questoes_lista = []
while True:
	nome = raw_input()
	if nome == "**":
		break
	else:
		nomes.append(nome)
		total = 0
		while True:
			questoes = raw_input()
			if questoes == "*":
				questoes_lista.append(total)
				break
			total += int(questoes)

print "Relatório de novas questões:\n"

soma = 0
for i in range(len(nomes)):
	print "%s: %d" %(nomes[i], questoes_lista[i])
	soma += questoes_lista[i]
	
print "---\nTotal de novas questões: %d" % soma

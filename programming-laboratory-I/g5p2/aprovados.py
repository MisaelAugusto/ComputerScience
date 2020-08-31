# coding: utf-8
# ALuno: Misael Augusto
# Matrícula: 117110525
# Problema: Aprovados no ENEM

alunos = []
notas = []
while True:
	aluno_nota = raw_input().split()
	if aluno_nota[0] == "fim":
		nota_corte = int(raw_input())
		break
	else:
		alunos.append(aluno_nota[0])
		notas.append(int(aluno_nota[1]))

reprovados = 0
for i in range(len(alunos)):
	if notas[i] >= nota_corte:
		print "%s, %d" % (alunos[i], notas[i])
	else:
		reprovados += 1
		if reprovados == len(alunos):
			print "Nenhum candidato aprovado."
			break

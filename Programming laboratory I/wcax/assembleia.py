# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Analytics Assembleia

def conta_votos(votacoes, id_votacao):
	votos = [0, 0]
	for i in range(len(votacoes)):
		dados = votacoes[i].split(",")
		if int(dados[2]) == id_votacao:
			if dados[1] == "sim":
				votos[0] += 1
			else:
				votos[1] += 1
	return votos

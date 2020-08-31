# coding: utf-8
# ALuno: Misael Augusto
# Matrícula: 117110525
# Problema: Avaliação de Desempenho Acadêmico

N = int(raw_input())
pontuacao_ensino = int(raw_input())
pontuacao_producao = int(raw_input())
pontuacao_orientacao = int(raw_input())
pontuacao_administrativas = int(raw_input())

total = pontuacao_ensino + pontuacao_producao + pontuacao_orientacao + pontuacao_administrativas

if N < 4:
	print "Promoção indeferida. Número de semestres insuficiente."
else:
	if pontuacao_ensino >= 320:
		if pontuacao_producao >= 100:
			if pontuacao_orientacao >= 20:
				media = total / 4.0
				if media > 140:
					print "Promoção deferida. Parabéns!"
				else:
					print "Promoção indeferida. Média insuficiente."
			else:
				print "Promoção indeferida. Pontuação mínima não alcançada."
		else:
			print "Promoção indeferida. Pontuação mínima não alcançada."
	else:
		print "Promoção indeferida. Pontuação mínima não alcançada."



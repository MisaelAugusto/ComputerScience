# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Atendimentos no SAMU

total = 0
atendimentos_lista = []
for i in range(12):
	atendimentos = int(raw_input())
	total += atendimentos
	atendimentos_lista.append(atendimentos)

media = total / 12.0
print "Média mensal de atendimentos: %.2f" % media
print "----"
for i in range(len(atendimentos_lista)):
	if atendimentos_lista[i] > media:
		print "Mês %d: %d" % (i + 1, atendimentos_lista[i])

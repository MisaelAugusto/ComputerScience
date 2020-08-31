# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Autorização voos

tempo_total = int(raw_input())
avioes = int(raw_input())

autorizados = 0
for i in range(avioes):
	tempo_aviao = int(raw_input())
	if tempo_aviao <= tempo_total:
		autorizados += 1
		tempo_total -= tempo_aviao
print "%d voo(s) autorizados." % autorizados

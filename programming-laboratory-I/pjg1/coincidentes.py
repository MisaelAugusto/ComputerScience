# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Letras coincidentes

palavra1 = raw_input()
palavra2 = raw_input()

print "Letras coincidentes"

coincidentes = 0
for i in range(len(palavra1)):
	if palavra1[i] == palavra2[i]:
		print "'%s' na posição %d" % (palavra1[i], i + 1)
		coincidentes += 1

porcentagem = coincidentes * 100 / (len(palavra1) + len(palavra2))
print "Total de letras coincidentes: %d (%d%%)" % (coincidentes, porcentagem)

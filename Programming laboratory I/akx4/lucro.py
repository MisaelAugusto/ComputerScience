# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Lucro Mensal de uma Empresa

meses = ["jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez"]
lucros = []

for i in range(12):
	valores = raw_input().split()
	lucro = float(valores[0]) - float(valores[1])
	lucros.append(lucro)
for i in range(12):
	if lucros[i] >= 0:
		print "%s  %.1f" % (meses[i], lucros[i])
	else:
		print "%s %.1f" % (meses[i], lucros[i])

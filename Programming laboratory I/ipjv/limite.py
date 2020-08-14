# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Limite açude

limite = float(raw_input())
nivel_atual = float(raw_input())

while nivel_atual < limite:
	operacao = raw_input().split()
	if operacao[0] == "chuva" or operacao[0] == "afluente":
		nivel_atual += float(operacao[1])
	else:
		if (nivel_atual - float(operacao[1])) < 0:
			continue
		else:
			nivel_atual -= float(operacao[1])

print "Açude passou a liberar água."
print "Nível: %.2f" % nivel_atual

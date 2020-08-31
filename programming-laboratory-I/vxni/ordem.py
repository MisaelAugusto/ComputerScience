# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Ordem Alfabética

N = int(raw_input())

palavras = []
for i in range(N):
	palavras.append(raw_input())
	
print "---"
palavra_referencia = raw_input()

antes = 0
depois = 0
for palavra in palavras:
	if palavra != palavra_referencia:
		if palavra < palavra_referencia:
			antes += 1
		if palavra > palavra_referencia:
			depois += 1
	else:
		continue

print "%d antes" % antes
print "%d depois" % depois

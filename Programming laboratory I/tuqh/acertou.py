# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Quem acertou menos

N = int(raw_input())

erros_lista = []
for i in range(N):
	erros = 0
	testes = raw_input()
	for t in testes:
		if t == "f":
			erros += 1
	erros_lista.append(erros)
	 
mais_erros = 0
for i in range(len(erros_lista)):
	if erros_lista[i] > mais_erros:
		mais_erros = erros_lista[i]
		aluno = i + 1
print "O aluno %d errou %d teste(s)." % (aluno, mais_erros)

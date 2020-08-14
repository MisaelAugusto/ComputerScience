# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Números Oscilantes

numero = raw_input()
for i in range(len(numero) - 1):
	condicao1 = (int(numero[i]) % 2 == 0 and int(numero[i + 1]) % 2 != 0)
	condicao2 = (int(numero[i]) % 2 != 0 and int(numero[i + 1]) % 2 == 0)
	if condicao1 or condicao2:
		mensagem = "verdadeiro"
	else:
		mensagem = "falso"
		break
		
print "%s: %d algarismos." % (mensagem, len(numero))

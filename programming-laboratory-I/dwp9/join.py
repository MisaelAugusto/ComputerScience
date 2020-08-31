# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Minha Implementação para o Método join

def meu_join(delimitador, sequencia_de_string):
	string = sequencia_de_string[0]
	for i in range(1, len(sequencia_de_string)):
		string += delimitador + sequencia_de_string[i]
	
	return string

print meu_join("*", "abc")

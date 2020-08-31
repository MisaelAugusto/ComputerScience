# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Único

def unico(string):
	string_final = ""
	for i in range(len(string) - 1):
		if string[i] != string[i + 1]:
			string_final += string[i]		
	if len(string) != 0:
		string_final += string[-1]
	return string_final
	

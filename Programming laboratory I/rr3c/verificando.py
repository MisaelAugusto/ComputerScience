# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Verificando se uma String é Substring de Outra String

def is_substring(str1, str2):
	tamanho = len(str2)
	for i in range(len(str1) - tamanho + 1):
		s = ""
		for j in range(tamanho):
			s += str1[i + j]
		if s == str2:
			return True
	
	return False

print is_substring("baaadoi", "oi")
		

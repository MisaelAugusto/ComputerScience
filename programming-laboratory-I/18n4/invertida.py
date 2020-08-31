# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Sequencia Invertida 3 a 3

def inverte3a3(s):
	trios = []
	for i in range(0, len(s), 3):
		trios.append(s[i] + s[i + 1] + s[i + 2])
	
	s_final = ""
	for i in range(len(trios) - 1, -1, -1):
		s_final += trios[i]
		
	return s_final
	
print inverte3a3("paisimtio")

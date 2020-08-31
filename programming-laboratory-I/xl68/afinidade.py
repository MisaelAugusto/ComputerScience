# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Afinidade Musical

def tem_afinidade(l1, l2):
	n = 0
	for artista1 in l1:
		for artista2 in l2:
			if artista1 == artista2:
				n += 1
				break
	
	if n >= 3:
		return True
	else:
		return False
		

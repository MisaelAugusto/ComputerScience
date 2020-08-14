# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Acordes aprendidos

def acordes(musica_1, musica_2):
	acordes = []
	for acorde in musica_1:
		acordes.append(acorde)

	for m in musica_2:
		n = 0
		for acorde in acordes:
			if m != acorde:
				n += 1
		if n == len(acordes):
			acordes.append(m)		
	
	return acordes

print acordes(["c", "d", "dm"], ["c", "a"])

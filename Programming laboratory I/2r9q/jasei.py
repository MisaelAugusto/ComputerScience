# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Já sei tocar essa música

def sei_tocar_musica(musica, acordes):
	n = 0
	for i in range(len(musica)):
		for j in range(len(acordes)):
			if musica[i] == acordes[j]:
				n += 1
				break
	
	if n == len(musica):
		return True
	else:
		return False

# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Falta um

def encontra_rotulo_perdido(rotulos_enviados, rotulos_recebidos):
	for rotulo in rotulos_enviados:
		n = 0
		for rc in rotulos_recebidos:
			if rotulo == rc:
				break
			else:
				n += 1
	
		if n == len(rotulos_recebidos):
			return rotulo

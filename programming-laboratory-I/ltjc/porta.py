# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Porta Eletrônica

registrados = []
while True:
	entrada = raw_input().split()
	if entrada[0] == "S":
		break
	else:
		categoria = entrada[1]
		if entrada[0] == "R":	
			registrados.append(categoria[0])
		else:
			n = 0
			for r in registrados:
				if r == categoria[0]:
					n += 1
			print n

				
		
			

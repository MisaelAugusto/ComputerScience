# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Elementos Químicos

while True:
	dic = {"H": 1, "S": 32, "O": 16, "C": 12, "Ca": 40, "Na": 23, "P": 31}
	entrada = raw_input().split()
	if entrada[0] == "fim":
		break
	else:
		MM = 0
		i = 0
		while i < len(entrada) - 1:
			if entrada[i + 1].isdigit() :
				MM += dic[entrada[i]] * int(entrada[i + 1])
				i += 1
			else:
				MM += dic[entrada[i]]
			i += 1
		
		if not(entrada[-1].isdigit()):
			MM += dic[entrada[-1]]
		
		print MM
			

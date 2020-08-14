# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Agenda Ordenada

nomes = []
while True:
	 nome = raw_input()
	 if nome == "####":
		 break
	 else:
		 nomes.append(nome)
		 inicia = True
		 n = len(nomes)
		 while inicia and n > 1:
			 inicia = False
			 for i in range(len(nomes) - 1):
				if nomes[i][0] > nomes[i + 1][0]:
					nomes[i], nomes[i + 1] = nomes[i + 1], nomes[i]
					inicia = True
				elif nomes[i][0] == nomes[i + 1][0]:
					x = 1
					while x < len(nomes[i + 1]):
						if x < len(nomes[i]) and nomes[i][x] > nomes[i + 1][x]:
							nomes[i], nomes[i + 1] = nomes[i + 1], nomes[i]
							inicia = True
							break
						x += 1
			 n -= 1

		 for i in range(len(nomes)):
			 if nomes[i] == nome:
				 print "* %s" % nomes[i]
			 else:
				 print nomes[i]
		 print "----"

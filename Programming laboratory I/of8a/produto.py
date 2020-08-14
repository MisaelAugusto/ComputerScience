# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Produto de dois somatórios

digitos = raw_input()

soma_par = 0
soma_impar = 0
for i in range(len(digitos)):
	if i % 2 > 0:
		soma_impar += int(digitos[i])
	else:
		soma_par += int(digitos[i])
total = soma_impar * soma_par
total = str(total)
n = 5 - len(total)
total = ("0" * n) + total
	
print total

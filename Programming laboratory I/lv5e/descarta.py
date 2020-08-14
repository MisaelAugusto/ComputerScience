# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Descarta coincidente

N = int(raw_input())
numeros = []
descartados = 0
aceitos = 0
descartados_lista = []
aceitos_lista = []


for i in range(N):
	numeros.append(raw_input())
	
for n in numeros:
	ciclos = 0
	for i in range(len(n)):	
		if int(n[i]) == i:
			descartados += 1
			descartados_lista.append(n)
			break
		else:
			ciclos += 1
	if ciclos == len(n):
		aceitos += 1
		aceitos_lista.append(n)
print "---"
print "%d aceito(s)" % aceitos
for i in aceitos_lista:
	print i

print "%d descartado(s)" % descartados
for i in descartados_lista:
	print i

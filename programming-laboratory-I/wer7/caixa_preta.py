# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Caixa Preta

N = int(raw_input())

validos = 0
ciclos = 1
for i in range(N):
	medicao = raw_input().split()
	if int(medicao[0]) >= 0:
		validos += 1
		if int(medicao[1]) >= 0:
			validos += 1
			if int(medicao[2]) >= 0:
				validos += 1
			else:
				print "dado inconsistente. altitude negativa."
				break
		else:
			print "dado inconsistente. combustível negativo."
			break
	else:
		print "dado inconsistente. peso negativo."
		break
	ciclos += 1
for i in range(N - ciclos):
	medicao = raw_input().split()			
		
print "%d dados válidos." % validos

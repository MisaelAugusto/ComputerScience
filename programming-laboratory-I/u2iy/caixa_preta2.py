# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Caixa Preta Descartando Leituras

peso = 0
combustivel = 0
altitude = 0
while True:
	entrada = raw_input().split()
	if int(entrada[0]) >= 0:
		peso += 1
		if int(entrada[1]) >= 0:
			combustivel += 1
			if int(entrada[2]) >= 0:
				altitude += 1
			else:
				print "dado inconsistente. altitude negativa."
				break
		else:
			print "dado inconsistente. combustível negativo."
			break
	else:
		print "dado inconsistente. peso negativo."
		break
				
				
print "peso: %d" % peso
print "combustível: %d" % combustivel
print "altitude: %d" % altitude

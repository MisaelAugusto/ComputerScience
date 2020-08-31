# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Semi César

def cesar(msg, d):
	msg = list(msg)
	for i in range(len(msg)):
		if 97 <= ord(msg[i]) < 123:
			if ord(msg[i]) + d > ord("z"):
				n = (ord(msg[i]) + d) - ord("z")
				n += ord("a") - 1
			else:	
				n = ord(msg[i]) + d
			msg[i] = chr(n)
	msg = "".join(msg)
	return msg

print cesar("aaaaaaaaa", 4)

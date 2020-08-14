# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Primeiro Menor

def primeiro_menor(num, numeros):
	aux = 0
	if len(numeros) > 0:
		for i in range(len(numeros)):
			if int(numeros[i]) < num:
				indice = i
				break
			else:
				aux += 1
				
	if aux == len(numeros) or len(numeros) == 0:
		indice = -1
			
	return indice
	
def main():
	numeros = raw_input().split()
	num = int(raw_input())
	i = primeiro_menor(num, numeros)
	if i == -1:
		print "sem menores que %d" % num
	else:
		print "primeiro menor que %d: %s" % (num, numeros[i])
	
if __name__ == "__main__":
	main()


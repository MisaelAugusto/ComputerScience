# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Resolve Vizinhos

def resolve_vizinhos(lista):
	for i in range(len(lista) - 1):
		if lista[i] == lista[i + 1]:
			lista[i] += 1
			if lista[i] == lista[i - 1]:
				lista[i] += 1
			
	return lista

print resolve_vizinhos([1, 2, 5, 5, 8, 4])
print resolve_vizinhos([])
print resolve_vizinhos([1, 1, 1])

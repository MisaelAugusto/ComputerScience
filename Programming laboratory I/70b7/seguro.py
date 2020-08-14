# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Cálculo de Seguro

def calcula_seguro(valor_veiculo, lista):
	dados_cliente = []
	verdadeiros = [10, 20, 20, 20, 10]
	falsos = [20, 10, 10, 10, 20]
	pontos = 0
	if lista[0] <= 21:
		pontos += 20
	elif 22 <= lista[0] <= 30:
		pontos += 15
	elif 31 <= lista[0] <= 40:
		pontos += 12
	elif 41 <= lista[0] <= 60:
		pontos += 10
	else:
		pontos += 20
		
	for i in range(1, len(lista) - 1):
		if lista[i]:
			pontos += verdadeiros[i - 1]
		else:
			pontos += falsos[i - 1]
		
	if lista[-1] == "Lazer" or lista[-1] == "Misto":
		pontos += 20
	else:
		pontos += 10
		
	if pontos <= 80:
		mensagem = "Risco Baixo"
		valor = valor_veiculo * 0.1
	elif 80 < pontos <= 100:
		mensagem = "Risco Medio"
		valor = valor_veiculo * 0.2
	else:
		mensagem = "Risco Alto"
		valor = valor_veiculo * 0.3
	
	dados_cliente.append(pontos)
	dados_cliente.append(mensagem)
	dados_cliente.append(valor)
	
	return dados_cliente

print calcula_seguro(2000.0, [21, True, True, True, True, True, "Misto"])
		

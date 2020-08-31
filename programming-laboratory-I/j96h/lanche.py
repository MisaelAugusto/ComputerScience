# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Lanche mais pedido

def lanchemaispedido(pedidos):
	frequencias = []
	pedidos_lista = []
	if len(pedidos) > 1:
		for i in range(len(pedidos)):
			frequencia = 1
			for j in range(len(pedidos)):
				if i != j and pedidos[i] == pedidos[j]:
					frequencia += 1
					pedido = pedidos[i]	

			if frequencia > (len(pedidos) / 2):
				return pedido
	
	if len(pedidos) == 1:
		return pedidos[0]


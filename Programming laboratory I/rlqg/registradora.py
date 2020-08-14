# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Caixa Registradora

def caixa_registradora(vendas, meta):
	total = 0.0
	comissoes = 0.0
	lista = []
	for valor in vendas:
		if valor < 1000:
			comissoes += (valor * 0.05)
		elif 1000 <= valor < 5000:
			comissoes += (valor * 0.10)
		else:
			comissoes += (valor * 0.15)
		total += valor
	if (total - comissoes) >= meta:
		mensagem = "Lucro"
	else:
		mensagem = "Prejuizo"
	lista.append(total)
	lista.append(comissoes)
	lista.append(mensagem)
	
	return lista
		


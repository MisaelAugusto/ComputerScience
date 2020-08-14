salario_atual = float(raw_input("Valor atual? "))
salario_novo = float(raw_input("Novo valor? "))

reajuste = (salario_novo - salario_atual) / salario_atual * 100

print "Reajuste de %.1f%%" %reajuste

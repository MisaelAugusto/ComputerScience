# coding: utf-8
sb = float(raw_input())
horas = int(raw_input())
hb = sb *1.0 / horas
print "Salário Bruto =", sb
print "Hora Bruta =", hb
print "Desconto IR =", sb*0.11
print "Desconto INSS =", sb*0.08
print "Desconto Sindicato =", sb*0.05
print "Salário Líquido =", sb - sb*0.24
print "Hora Líquida =", hb - hb*0.24

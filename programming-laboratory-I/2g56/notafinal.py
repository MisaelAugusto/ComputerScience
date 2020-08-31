# coding: utf-8 
print "== Estágio 1 =="
p1 = float(raw_input("Peso? "))
n1 = float(raw_input("Nota? "))
print "== Estágio 2 =="
p2 = float(raw_input("Peso? "))
n2 = float(raw_input("Nota? "))
print "== Estágio 3 =="
p3 = float(raw_input("Peso? "))
n3 = float(raw_input("Nota? "))
print "== Resultados =="
mp = (p1 * n1 + p2 * n2 + p3 * n3) / (p1 + p2 + p3)
mf1 = (5.0 - (mp * 0.6))/0.4
mf2 = (7.0 - (mp * 0.6))/0.4

print "Média parcial:", mp
print "Nota na final, pra média 5.0 = %.1f" %mf1
print "Nota na final, pra média 7.0 = %.1f" %mf2


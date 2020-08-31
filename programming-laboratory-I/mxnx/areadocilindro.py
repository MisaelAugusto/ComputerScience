# coding: utf-8
import math

print "Cálculo da Superfície de um Cilindro"
print "---"

diametro = float(raw_input("Medida do diâmetro? "))
altura = float(raw_input("Medida da altura? "))
raio = diametro / 2
print "---"
area = 2 * math.pi * raio * altura + 2 * math.pi * raio **2
print "Área calculada: %.2f" %area

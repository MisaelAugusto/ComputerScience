# coding: utf-8
import math
raio = float(raw_input())
area_circulo = math.pi * raio**2
lado_quadrado = 2 * (raio * math.sqrt(2) / 2)
area_quadrado = lado_quadrado **2
area_nao_comum = area_circulo - area_quadrado
print "Área não comum: %.5f" %area_nao_comum


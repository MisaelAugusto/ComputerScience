# coding: utf-8
import math

velocidade = float(raw_input())
diametro = float(raw_input())
tempo = int(raw_input())
area = math.pi * (diametro/2.0) **2
vazao = velocidade * area * 1000
litros = tempo * vazao
print "Quantidade de água =", litros, "litros."

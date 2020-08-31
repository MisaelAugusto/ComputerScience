# coding: utf-8
posicao_inicial = float(raw_input())
velocidade = float(raw_input())
tempo = float(raw_input())
posicao_final = posicao_inicial + (velocidade * tempo)
print "Posição final do móvel"
print "S(%.1f) = %.1f m" %(tempo, posicao_final)



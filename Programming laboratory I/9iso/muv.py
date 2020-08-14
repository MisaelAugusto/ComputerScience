# coding: utf-8
posicao_inicial = float(raw_input("Posição inicial? "))
velocidade_inicial = float(raw_input("Velocidade inicial? "))
tempo = float(raw_input("Tempo? "))
aceleracao = float(raw_input("Aceleração? "))
print ""
print "Dados da questão\n================"
print "   Posição inicial: %.2f m" %posicao_inicial
print "Velocidade inicial: %.2f m/s" %velocidade_inicial
print "        Aceleração: %.2f m/s2" %aceleracao
print "             Tempo: %.2f s" %tempo
velocidade_final = velocidade_inicial + aceleracao * tempo
velocidade_media = (velocidade_inicial + velocidade_final) / 2
posicao_final = posicao_inicial + velocidade_inicial * tempo + aceleracao * tempo**2 / 2
print "  Velocidade final: %.2f m/s" %velocidade_final
print "  Velocidade média: %.2f m/s" %velocidade_media
print "     Posição final: %.2f m" %posicao_final

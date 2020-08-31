# coding: utf-8
convidados = int(raw_input())
op1_inteira = 32 / convidados
op1_resto = 32 % convidados
op2 = 32.0 / convidados
print "Opção 1: %i fatias cada, %i de resto" %(op1_inteira, op1_resto)
print "Opção 2: %.2f fatias cada" % op2


# coding: utf-8
usuario1 = raw_input()
espaco1 = float(raw_input())
espaco1 = espaco1 / (1024**2)

usuario2 = raw_input()
espaco2 = float(raw_input())
espaco2 = espaco2 / (1024**2)

usuario3 = raw_input()
espaco3 = float(raw_input())
espaco3 = espaco3 / (1024**2)

print "SPLab - Espaço utilizado pelos usuários"
print "---------------------------------------------"
print "Nr., Usuário, Espaço Utilizado"
print "" 
print "1, %s, %.2f MB" %(usuario1, espaco1)
print "2, %s, %.2f MB" %(usuario2, espaco2)
print "3, %s, %.2f MB" %(usuario3, espaco3)
print ""
espaco_total = espaco1 + espaco2 + espaco3
print "Espaço total ocupado: %.2f MB" % espaco_total
espaco_medio = (espaco1 + espaco2 + espaco3) / 3.0
print "Espaço médio ocupado: %.2f MB" % espaco_medio

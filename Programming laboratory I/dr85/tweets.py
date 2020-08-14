# coding: utf-8

tweets = int(raw_input())
paginas = tweets / 400
resto = tweets % 400
perdidos = resto * 100.0 / tweets 
print "Serão necessárias %i página(s) para visualizar os tweets." %paginas
print "%.1f%% dos tweets serão perdidos." %perdidos

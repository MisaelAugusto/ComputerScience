# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Ciclo Trigonométrico

angulo = float(raw_input())
while angulo > 360:
	angulo = angulo - 360

angulo = angulo / 90

if 0 < angulo < 1:
	print "Quadrante 1"
elif 1 < angulo < 2:
	print "Quadrante 2"
elif 2 < angulo < 3:
	print "Quadrante 3"
elif 3 < angulo < 4:
	print "Quadrante 4"
else:
	print "Sobre eixos"
	

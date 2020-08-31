# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Diferença entre Dois Horários no Dia

def quanto_tempo(horario1, horario2):
	dif_horas = abs(int(horario2[0] + horario2[1]) - int(horario1[0] + horario1[1]))
	if int(horario2[3] + horario2[4]) < int(horario1[3] + horario1[4]):
		dif_horas -= 1
		dif_minutos = int(horario2[3] + horario2[4]) + (60 - int(horario1[3] + horario1[4]))
	else:	
		dif_minutos = abs(int(horario2[3] + horario2[4]) - int(horario1[3] + horario1[4]))
	return "%d hora(s) e %d minuto(s)" % (dif_horas, dif_minutos)

print quanto_tempo("07:15", "09:18")
print quanto_tempo("22:05", "23:55")
print quanto_tempo("19:15", "20:00")

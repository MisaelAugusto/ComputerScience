# coding: utf-8
# Aluno: Misael Augusto
# Matrícula: 117110525
# Problema: Conversão de Matrículas na UFCG

matricula = list(raw_input())
matricula.append("0")
matricula[0] = "1"

for i in range(len(matricula) - 1, 5, -1):
	matricula[i], matricula[i - 1] = matricula[i - 1], matricula[i]

matricula = "".join(matricula)

print matricula

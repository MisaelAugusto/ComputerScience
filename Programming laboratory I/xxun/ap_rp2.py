# coding: utf-8
aprovados = int(raw_input())
reprovados = int(raw_input())
print "Análise da Turma\n==="
print "Número de aprovados? Número de reprovados? ---"
print "Total de alunos na turma:", aprovados + reprovados
print "Aprovados:", aprovados, "=", "%.1f%%" %(100.0*aprovados / (aprovados + reprovados))
print "Reprovados:", reprovados, "=", "%.1f%%" %(100.0*reprovados / (aprovados + reprovados))


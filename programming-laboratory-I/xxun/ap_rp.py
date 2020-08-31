# coding: utf-8
print "Análise da Turma \n==="
aprovados = int(raw_input("Número de aprovados? "))
reprovados = int(raw_input("Número de reprovados? "))
print "---"
total = aprovados + reprovados
ta = 1.0*aprovados / total * 100
tr = 1.0*reprovados / total * 100
print "Total de alunos na turma:", total
print "Aprovados:", aprovados, "=", "%.1f%%" %ta
print "Reprovados:", reprovados, "=", "%.1f%%" %tr





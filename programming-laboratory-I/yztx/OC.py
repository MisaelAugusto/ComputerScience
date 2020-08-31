# coding: utf-8
pt = float(raw_input("Digite o preço da unidade do tijolo (Em reais): "))
ht = float(raw_input("Digite a altura do tijolo (Em metros): "))
ct = float(raw_input("Digite o comprimento do tijolo (Em metros): "))
hp = float(raw_input("Digite a altura das paredes (Em metros): "))
cp = float(raw_input("Digite o comprimento das paredes (Em metros): "))

ap =  hp * cp
at = ht * ct
nt = 1.0*ap/at
print "O número total de tijolos é %.1f e o orçamento final é de R$ %.1f" %(nt,1.0*nt*pt)

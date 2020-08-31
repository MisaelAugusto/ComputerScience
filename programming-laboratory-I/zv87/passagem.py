# coding: utf-8
passagem = float(raw_input())
aliquota = float(raw_input())
valor_passagem = passagem * aliquota + 51.00
print "Valor da passagem: R$ %.2f" %valor_passagem
print ""
print "Pagamento:"
print "1. À vista. R$ %.2f" %(valor_passagem*0.75)
print "2. Em 6 parcelas. Total: R$ %.2f\n   6 x R$ %.2f" %(valor_passagem*0.95, (valor_passagem*0.95)/6)
print "3. Em 10 parcelas. Total: R$ %.2f\n   10 x R$ %.2f" %(valor_passagem, valor_passagem/10)

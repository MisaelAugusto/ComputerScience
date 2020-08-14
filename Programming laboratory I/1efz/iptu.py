# coding: utf-8

area = float(raw_input("Área construída? "))
aliquota = float(raw_input("Alíquota? "))
iptu = area * aliquota + 35.00
print "IPTU: R$ %.2f" %iptu
print ""
print "Pagamento:"
print "1. Quota única. R$ %.2f" %(iptu*0.75)
print "2. Em 6 parcelas. Total: R$ %.2f\n   6 x R$ %.2f" %(iptu*0.95, (iptu*0.95) / 6)
print "3. Em 10 parcelas. Total: R$ %.2f\n   10 x R$ %.2f" %(iptu, iptu / 10)



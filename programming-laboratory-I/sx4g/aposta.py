num1 = int(raw_input())
num2 = int(raw_input())
num3 = int(raw_input())
if num1 > 10:
	num1 = num1%11
if num2 > 10:
	num2 = num2%11
if num3 > 10:
	num3 = num3%11
print "%02.i-%02.i-%02.i" %(num1, num2, num3)

		


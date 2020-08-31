# coding: utf-8
x1 = int(raw_input())
y1 = int(raw_input())
x2 = int(raw_input())
y2 = int(raw_input())
x3 = int(raw_input())
y3 = int(raw_input())

lado_a = ((x1 - x2)**2 + (y1 - y2)**2)**(0.5)
lado_b = ((x2 - x3)**2 + (y2 - y3)**2)**(0.5)
lado_c = ((x3 - x1)**2 + (y3 - y1)**2)**(0.5)
perimetro = lado_a + lado_b + lado_c
print "O perímetro é de %.2f" %perimetro


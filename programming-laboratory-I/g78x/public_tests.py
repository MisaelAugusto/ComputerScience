import unittest
import sys

undertest = __import__(sys.argv[-1].split(".py")[0])
anula = getattr(undertest, 'anula', None)

class PublicTests(unittest.TestCase):
 
   def test_do_enunciado(self):
       lista1 = [1, 2, -2, 3, 4]
       assert anula(lista1) == None
       assert lista1 == [1, 3, 4]

   def test_do_enunciado_1(self):
       lista2 = [1, 2, -2, -1, 4]
       assert anula(lista2) == None
       assert lista2 == [4]
 
if __name__ == '__main__':
    loader = unittest.TestLoader()
    runner = unittest.TextTestRunner()
    runner.run(loader.loadTestsFromModule(sys.modules[__name__])) 

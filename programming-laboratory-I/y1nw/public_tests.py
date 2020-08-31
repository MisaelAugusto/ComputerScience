import unittest
import sys

undertest = __import__(sys.argv[-1].split(".py")[0])
na_posicao = getattr(undertest, 'na_posicao', None)

class PublicTests(unittest.TestCase):

   def test_exemplo(self):
     l = [10, 20, 30]
     a_inserir = [(5, 1), (-2, 4), (0, 0)]
     assert na_posicao(l, a_inserir) == None
     assert l == [0, 10, 5, 20, 30, -2]


if __name__ == '__main__':
    loader = unittest.TestLoader()
    runner = unittest.TextTestRunner()
    runner.run(loader.loadTestsFromModule(sys.modules[__name__]))

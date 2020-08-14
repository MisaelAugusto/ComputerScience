# coding: utf-8
import unittest
import sys

undertest = __import__(sys.argv[-1].split(".py")[0])
remove_maiores = getattr(undertest, 'remove_maiores', None)

class PublicTests(unittest.TestCase):
    
    def test_1(self):
        lista1 = [8, 7, 3, 8, 2]
        assert remove_maiores(lista1) == None
        assert lista1 == [7, 3, 2]        


if __name__ == '__main__':
    loader = unittest.TestLoader()
    runner = unittest.TextTestRunner()
    runner.run(loader.loadTestsFromModule(sys.modules[__name__]))

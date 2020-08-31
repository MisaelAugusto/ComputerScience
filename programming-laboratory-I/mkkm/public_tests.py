import unittest
import sys

undertest = __import__(sys.argv[-1].split(".py")[0])
agrupa_pares_impares = getattr(undertest, 'agrupa_pares_impares', None)

class AcceptanceTests(unittest.TestCase):

    def test_example(self):
        assert agrupa_pares_impares([10, 24, 97, 88]) == {"pares":[10, 24, 88], "impares":[97]}
        assert agrupa_pares_impares([11, 23, 35]) == {"pares":[ ], "impares":[11, 23, 35]}

if __name__ == '__main__':
    loader = unittest.TestLoader()
    runner = unittest.TextTestRunner()
    runner.run(loader.loadTestsFromModule(sys.modules[__name__]))

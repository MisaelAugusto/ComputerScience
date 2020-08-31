import unittest
import sys

undertest = __import__(sys.argv[-1].split(".py")[0])
is_substring = getattr(undertest, 'is_substring', None)

class AcceptanceTests(unittest.TestCase):

    def test_1(self):
        assert is_substring('boiada','oi')
        assert not is_substring('casorio', 'casa')

if __name__ == '__main__':
    loader = unittest.TestLoader()
    runner = unittest.TextTestRunner()
    runner.run(loader.loadTestsFromModule(sys.modules[__name__]))

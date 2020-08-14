import unittest
import sys

undertest = __import__(sys.argv[-1].split(".py")[0])
sei_tocar_musica = getattr(undertest, 'sei_tocar_musica', None)

class PublicTests(unittest.TestCase):

    def test_example(self):
        musica = ["a", "d", "dm"]
        acordes = ["a", "d"]
        assert not sei_tocar_musica(musica, acordes)

    def test_exemplo2(self):
        musica = ["a", "d"]
        acordes = ["a", "bm", "d", "c"]
        assert sei_tocar_musica(musica, acordes)


if __name__ == '__main__':
    loader = unittest.TestLoader()
    runner = unittest.TextTestRunner()
    runner.run(loader.loadTestsFromModule(sys.modules[__name__]))

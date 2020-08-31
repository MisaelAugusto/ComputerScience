import System.IO

-- 1
divTuple :: (Int, Int) -> Int
divTuple (x, 0) = undefined
divTuple (x, y) = div x y

-- 2
somatorio :: Int -> Int -> Int
somatorio a b = sum [a..b]

-- 3
somatorioRec :: Int -> Int -> Int
somatorioRec a b | a == b = b
                 | otherwise = a + somatorioRec (a + 1) b

-- 4
square :: Int -> Int
square x = x * x

-- 5
sumSquares :: Int -> Int -> Int
sumSquares x y = square x + square y

-- 6
higherOrderSum :: (Int -> Int) -> Int -> Int -> Int
higherOrderSum f a b = f a + f b

-- 7
hoSumSquares :: Int -> Int -> Int
hoSumSquares = higherOrderSum square

-- 8
mapFilter :: (Int -> Int) -> Int -> [Int] -> Int
mapFilter f p xs = undefined

main :: IO()
main = do
    print(divTuple (5, 3))
    print(somatorio 5 9)
    print(mapFilter square 1 [2..10])

import System.IO

-- 1
xor :: Bool -> Bool -> Bool
xor a b = (a && (not b)) || ((not a) && b)

impl :: Bool -> Bool -> Bool
impl a b = (not a) || b

equiv :: Bool -> Bool -> Bool
equiv a b = (impl a b) && (impl b a)

-- 2
square :: Int -> Int
square x = x * x

-- 3
pow :: Int -> Int -> Int
pow x 0 = 1
pow x y | y > 0 = x * pow x (y - 1)
        | otherwise = div 1 (pow x (-y))

-- 4
fatorial :: Int -> Int
fatorial 0 = 1
fatorial x = x * fatorial (x - 1)

-- 5
isPrime :: Int -> Bool
isPrime x = [y| y <- [1..x], (mod x y) == 0] == [1, x]

-- 6
fib :: Int -> Int
fib 0 = 0
fib 1 = 1
fib x = fib (x - 1) + fib (x - 2)

-- 7
mdc :: Int -> Int -> Int
mdc x 0 = x
mdc x y = mdc y (mod x y)

-- 8
mmc :: Int -> Int -> Int
mmc x y = div (x * y) (mdc x y)

-- 9
coprimo :: Int -> Int -> Bool
coprimo x y = (mdc x y) == 1

-- 10
goldbach :: Int -> [(Int, Int)]
goldbach x = [(a, b)| a <- filter isPrime [1..x-1], b <- filter isPrime [1..x-1], a + b == x]

main :: IO()
main = do
    print(xor True True)
    print(goldbach 30)

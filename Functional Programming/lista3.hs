import System.IO

-- 1.3
pow :: Int -> Int -> Int
pow = \x y -> if (y == 0) 
              then 1 
              else (if (y > 0)
                    then x * pow x (y - 1)
                    else div 1 (pow x (-y)))
                    
-- 1.4
fatorial :: Int -> Int
fatorial = \x -> if (x == 0)
                 then 1
                 else x * fatorial (x - 1)
                 
-- 1.5
isPrime :: Int -> Bool
isPrime = \x -> [y| y <- [1..x], (mod x y) == 0] == [1, x]

-- 1.6
fib :: Int -> Int
fib = \x -> if (x == 0)
            then 0
            else (if (x == 1)
                  then 1
                  else fib (x - 1) + fib (x - 2))
                  
-- 1.7
mdc :: Int -> Int -> Int
mdc = \x y -> if (y == 0)
              then x
              else mdc y (mod x y)
              
-- 1.8
mmc :: Int -> Int -> Int
mmc = \x y -> div (x * y) (mdc x y)

-- 1.9
coprimo :: Int -> Int -> Bool
coprimo = \x y -> (mdc x y) == 1

-- 1.10
goldbach :: Int -> [(Int, Int)]
goldbach = \x -> [(a, b)| a <- filter isPrime [1..x-1], b <- filter isPrime [1..x-1], a + b == x]

-- 2b.1
meuLast :: [Int] -> Int
meuLast = \xs -> if (xs == [])
                 then error "Lista vazia!"
                 else (if (tail xs) == []
                       then head xs
                       else meuLast (tail xs))
                       
-- 2b.2
penultimo :: [Int] -> Int
penultimo = \xs -> if (xs == [] || xs == [head xs])
                   then error "Lista sem penultimo"
                   else (if (tail (tail xs) == [])
                         then head xs
                         else penultimo (tail xs))
                         
-- 2b.3
elementAt :: Int -> [Int] -> Int
elementAt = \i xs -> if (i == 1)
                     then head xs
                     else elementAt (i - 1) (tail xs)

-- 2b.4
meuLength :: [Int] -> Int
meuLength = \xs -> if (xs == [])
                   then 0
                   else 1 + meuLength (tail xs)

-- 2b.5
meuReverso :: [Int] -> [Int]
meuReverso = \xs -> if (xs == [])
                    then []
                    else meuReverso (tail xs) ++ [head xs]

-- 2b.6
isPalindrome :: [Int] -> Bool
isPalindrome = \xs -> xs == (meuReverso xs)

-- 2b.7
compress :: [Int] -> [Int]
compress = \xs -> if (xs == [])
                  then []
                  else (if elem (head xs) (tail xs)
                        then compress (tail xs)
                        else [head xs] ++ compress (tail xs))

-- 2b.8


-- 2b.9
-- 2b.10

main :: IO()
main = do
    print(compress [])
    print(compress [1..5])
    print(compress [66, 1, 2, 3, 4, 1, 7, 5, 3, 1, 66])
